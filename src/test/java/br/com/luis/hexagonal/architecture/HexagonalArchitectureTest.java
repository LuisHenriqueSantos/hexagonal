package br.com.luis.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(
        packages = "br.com.luis.hexagonal",
        importOptions = DoNotIncludeTests.class
)
class HexagonalArchitectureTest {

    @ArchTest
    static final ArchRule application_should_not_depend_on_adapters_or_config =
            noClasses()
                    .that()
                    .resideInAPackage("..application..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage("..adapters..", "..config..");

    @ArchTest
    static final ArchRule domain_should_not_depend_on_frameworks =
            noClasses()
                    .that()
                    .resideInAPackage("..application.core.domain..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage(
                            "org.springframework..",
                            "jakarta..",
                            "javax..",
                            "lombok.."
                    );

    @ArchTest
    static final ArchRule ports_should_be_interfaces =
            classes()
                    .that()
                    .resideInAPackage("..application.ports..")
                    .should()
                    .beInterfaces();

    @ArchTest
    static final ArchRule adapters_should_not_be_accessed_by_application =
            layeredArchitecture()
                    .consideringOnlyDependenciesInLayers()
                    .layer("Config").definedBy("..config..")
                    .layer("AdaptersIn").definedBy("..adapters.in..")
                    .layer("AdaptersOut").definedBy("..adapters.out..")
                    .layer("Application").definedBy("..application..")
                    .whereLayer("Application").mayOnlyBeAccessedByLayers(
                            "Config",
                            "AdaptersIn",
                            "AdaptersOut"
                    )
                    .whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
                    .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
                    .whereLayer("Config").mayNotBeAccessedByAnyLayer();
}
