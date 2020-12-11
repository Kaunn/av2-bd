package br.edu.unijuazeiro.Gamestore.services;

import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.edu.unijuazeiro.Gamestore.Models.Employee.Employee;
import br.edu.unijuazeiro.Gamestore.dao.EmployeeDAO;

public class EmployeeCPTpassw {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void save(Employee employee) {
        if (employee.getCPF().length() > 15) {
        }
        employeeDAO.save(employee);
    }

    public void update(Employee employee) {
        if (employee.getPassword() == null) {
            throw new RuntimeException("Senha necessária. Favor, digite-a!");
        }
        String pwdCipher = BCrypt.withDefaults().hashToString(11, employee.getPassword().toCharArray());
        System.out.println(pwdCipher);
        employee.setPassword(pwdCipher);
        employeeDAO.update(employee);
    }

    public Employee login(String cpf, String password) {
        Employee empy = employeeDAO.findByCPF(cpf);
        if (empy == null) {
            throw new RuntimeException("Dados inválidos");
        }
        if (!BCrypt.verifyer().verify(password.toCharArray(), empy.getPassword().toCharArray()).verified) {
            throw new RuntimeException("Dados inválidos");
        }
        return empy;
    }

    public List<Employee> list() {
        return employeeDAO.list();
    }

}