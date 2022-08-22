package test;


import dao.ConfiguracaoJDBC;
import dao.impl.MedicamentoDaoH2;
import entities.Medicamento;
import org.apache.log4j.Logger;
import org.junit.Test;
import service.MedicamentoService;

public class MedicamentoTest {

    final static Logger LOGGER = Logger.getLogger(MedicamentoTest.class);

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2(new ConfiguracaoJDBC()));

    @Test
    public void guardarMedicamento() {

        LOGGER.info("Criando o 1º medicamento em memória.");
        Medicamento medicamento = new Medicamento("Ibuprofeno", "Aché", 495, 25.9);
        LOGGER.info("Medicamento em memória sem o ID.");
        System.out.println(medicamento);

        System.out.println("");

        LOGGER.info("Recebendo do BD o registro criado com ID.");
        Medicamento retorno = medicamentoService.salvar(medicamento);

        LOGGER.info("Medicamento recebido do H2 com ID.");
        System.out.println(retorno);
    }

}
