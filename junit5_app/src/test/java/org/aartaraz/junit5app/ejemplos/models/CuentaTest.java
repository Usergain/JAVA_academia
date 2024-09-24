package org.aartaraz.junit5app.ejemplos.models;

import static org.junit.jupiter.api.Assertions.*;

import org.aartaraz.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

class CuentaTest {
    Cuenta cuenta;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
        //Se ejecute antes de cada metodo
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {
        this.cuenta = new Cuenta("Arkaitz", new BigDecimal("1000.12345"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;

        System.out.println("Iniciando el metodo.");
        testReporter.publishEntry("ejecutnado: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod().orElse(null).getName()
                + " con las etiquetas " + testInfo.getTags());
    }

    @AfterEach
        //Se ejecuta despues de cada metodo
    void afterEach() {
        System.out.println("finalizanco metodo");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("finlizando el test");
    }

    @Tag("cuenta")
    @Nested
    @DisplayName("Probando atributos de cuenta corriente")
    class CuentaTestNombreSaldo {
        //Con opcion lambda es mas eficiente ya que no reserva espacio de memoria si no se ejecuta el error y por ende el mensaje
        @Test
        @DisplayName("el nombre!")
        void testNombreCuenta() {
            //Cuenta cuenta = new Cuenta("Arkaitz", new BigDecimal("1000.12345")); lo hemos pasado al metodo initMetodoTest
            testReporter.publishEntry(testInfo.getTags().toString());

            if (testInfo.getTags().contains("cuenta")) {
                testReporter.publishEntry("hacer algo con la etiqueta cuenta");
            }

            String esperado = "Arkaitz";
            String real = cuenta.getPersona();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(esperado, real, () -> "el nombre de la cuenta no es el que se esperaba: sew esperaba " + esperado
                    + " sin embargo fue " + real);
            assertTrue(real.equals("Arkaitz"), () -> "nombre cuenta esperada debe ser igual a la real");
        }

        @Test
        @DisplayName("El saldo!")
        void testSaldoCuenta() {
            //Cuenta cuenta = new Cuenta("Arkaitz", new BigDecimal("1000.12345"));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        @DisplayName("testeando referencias que sean iguales al metodo equals!")
        void testReferenciaCuenta() {
            cuenta = new Cuenta("Joh Doe", new BigDecimal("8900.9977"));
            Cuenta cuenta2 = new Cuenta("Joh Doe", new BigDecimal("8900.9977"));

//        assertNotEquals(cuenta2, cuenta);
            assertEquals(cuenta2, cuenta);
        }

    }

    @Nested
    class CuentaOperacionesTest {
        @Tag("cuenta")
        @Test
        void TestDebitoCuenta() {
            //Cuenta cuenta = new Cuenta("Arkaitz", new BigDecimal("1000.12345"));
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
        }

        @Test
        void TestCreditoCuenta() {
            //Cuenta cuenta = new Cuenta("Arkaitz", new BigDecimal("1000.12345"));
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Tag("banco")
        @Test
        @DisplayName("testeando ref. iguales con equals")
        void testTransferirDineroCuentas() {
            Cuenta cuenta1 = new Cuenta("John Doe", new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Arkaitz", new BigDecimal("1500.8989"));

            Banco banco = new Banco();
            banco.setNombre("Banco del Estado");
            banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
            assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
            assertEquals("3000", cuenta1.getSaldo().toPlainString());

        }
    }


    @Test
    @Tag("cuenta")
    @Tag("error")
    @DisplayName("probando el saldo de cuenta corriente, que sea valido")
    void testDineroInsuficienteExceptionCuenta() {
        //Cuenta cuenta = new Cuenta("Arkaitz", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }


    @Test
    @Tag("cuenta")
    @Tag("banco")
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("John Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Arkaitz", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        //test banco con sus cuentas
        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());

        //test banco con cuenta en particular
        assertEquals(2, banco.getCuentas().size());
        assertEquals("Banco del Estado", cuenta1.getBanco().getNombre());
        assertEquals("Arkaitz", banco.getCuentas().stream()
                .filter(c -> c.getPersona().equals("Arkaitz"))
                .findFirst()
                .get().getPersona());

        //test banco con cuenta en particula
        assertTrue(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("John Doe")));
    }

    @Test
    @DisplayName("probando relaciones entre las cuentas y el banco con assertAll")
        //@Disabled //Para dejar en standby y no salte error, cuando no te sale implementacion y tal..
    void testRelacionBancoCuentas2() {
        //forzando error:
        //fail();

        Cuenta cuenta1 = new Cuenta("John Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Arkaitz", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

        /*asi muestra los errores en el reporte, no como el anterior que si se encuetra un
        error lo muestra y los demás no los enseña */
        assertAll(() ->
                        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(),
                                () -> "el valor del saldo de la cuenta2 no es el esperado."),
                () ->
                        assertEquals("3000", cuenta1.getSaldo().toPlainString(),
                                () -> "el valor del saldo de la cuenta21no es el esperado."),
                () ->
                        assertEquals(2, banco.getCuentas().size(), () -> "el banco no tiene las cuentas esperadas."),
                () ->
                        assertEquals("Banco del Estado", cuenta1.getBanco().getNombre()),
                () ->
                        assertEquals("Arkaitz", banco.getCuentas().stream()
                                .filter(c -> c.getPersona().equals("Arkaitz"))
                                .findFirst()
                                .get().getPersona()),
                () ->
                        assertTrue(banco.getCuentas().stream()
                                .anyMatch(c -> c.getPersona().equals("John Doe"))));
    }

    @Nested
    class SistemaOperativoTest {
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows() {
        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
        void testSoloLinuxMac() {
        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        void testNoWindows() {
        }
    }

    @Nested
    class JavVersionTest {
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void soloJdk8() {
        }

        @Test
        @EnabledOnJre(JRE.JAVA_15)
        void soloJDK15() {
        }

        @Test
        @DisabledOnJre(JRE.JAVA_15)
        void testNoJDK15() {
        }
    }

    @Nested
    class SistemPropertiesTest {
        @Test
        void imprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + ":" + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = ".*17.*")
        void testJavaVersion() {
        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void testSolo64() {
        }

        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void testNo64() {
        }

        @Test
        @EnabledIfSystemProperty(named = "user.name", matches = "userg")
        void testUsername() {
        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev() {
        }

    }

    @Nested
    class VariableAmbienteTest {
        @Test
        void imprimirVariableAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> System.out.println(k + " = " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-17.0.2.*")
        void testJavaHome() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void testProcesadores() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
        void testEnv() {
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "prod")
        void testEnvProdDisable() {
        }

    }

    @Test
    void testSaldoCuentaDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        //Si es false se deshabilita y no lo testea.
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testSaldoCuentaDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        //Estas pruebas no se ejecutan si no se cumple, pero las que no estan dentro de la exprsion lambda si.
        assumingThat(esDev, () -> {
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.1234567, cuenta.getSaldo().doubleValue());
        });
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @DisplayName("Probando Debito Cuenta Repetir!")
    @RepeatedTest(value = 5, name = "{displayName} - Repeticion numero {currentRepetition} de {totalRepetitions}")
    void TestDebitoCuentaRepetir(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 3) {
            System.out.println("estamos en la repeticion " + info.getCurrentRepetition());
        }
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Tag("param")
    @Nested
    class PruebasParametrizadasTest {
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500", "1000.1235"})
        void TestDebitoCuentaValueSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000.1235"})
        void TestDebitoCuentaCsvSource(String index, String monto) {
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void TestDebitoCuentaCsvFileSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200,100,John,Arkaitz", "250,200,Pepe,Pepe", "300,300,maria,Maria", "510,500,Lucas,Lucas", "750,700,Juan,Juan", "1000.1235,1000.1235,Cata,Cata"})
        void TestDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual) {
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv")
        void TestDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual) {
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    @Tag("param")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("montoList")
    void TestDebitoCuentaMethodSource(String monto) {
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> montoList() {
        return Arrays.asList("100", "200", "300", "500", "700", "1000.12345");
    }

    @Nested
    @Tag("timeout")
    class EjemploTimeoutTest {
        @Test
        @Timeout(1)
        void pruebaTimeout() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(100); //invernando 6seg. para forzar el error
        }

        @Test
        @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
        void pruebaTimeout2() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(900); //invernando 6seg. para forzar el error
        }

        @Test
        void testTimeoutAssertions() {
            assertTimeout(Duration.ofSeconds(5), () -> {
                TimeUnit.MILLISECONDS.sleep(4000);
            });

        }
    }

}