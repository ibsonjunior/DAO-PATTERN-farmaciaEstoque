package service;

import dao.IDao;
import entities.Medicamento;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao){
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento salvarMedicamento(Medicamento medicamento) {
        return medicamentoDao.salvar(medicamento);
    }

    public Medicamento salvar(Medicamento medicamento) {
        return medicamentoDao.salvar(medicamento);
    }

}
