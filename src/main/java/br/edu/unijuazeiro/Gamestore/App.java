package br.edu.unijuazeiro.Gamestore;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.postgresql.core.v3.ConnectionFactoryImpl;

import br.edu.unijuazeiro.Gamestore.Models.Business.Product;
import br.edu.unijuazeiro.Gamestore.Models.Business.Sale;
import br.edu.unijuazeiro.Gamestore.Models.Client.Address;
import br.edu.unijuazeiro.Gamestore.Models.Client.Client;
import br.edu.unijuazeiro.Gamestore.Models.Employee.Employee;
import br.edu.unijuazeiro.Gamestore.dao.ClientDAO;
import br.edu.unijuazeiro.Gamestore.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.Gamestore.services.ClientCPTpassw;
import br.edu.unijuazeiro.Gamestore.services.EmployeeCPTpassw;
import br.edu.unijuazeiro.Gamestore.dao.EmployeeDAO;
import br.edu.unijuazeiro.Gamestore.dao.ProductDAO;
import br.edu.unijuazeiro.Gamestore.dao.SaleDAO;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("Seja Bem-vindo!");

 Employee employee = new Employee(name, cpf, function, passw);
 Client client = new Client(name, cpf, phone);
 Address address = new Address(state, city, nbhood, street, cep, number);
 Sale sale = new Sale(total);
 Product product = new Product(description, amount, price);
 
 Address address = new Address("AAA", "AB", "ABC", "ABBC", "000-00", "A00"); - PULE PARA LINHA 56
 Client client = new Client("Client-2", "000.000.000-02", "00 0 0000-0000", address); - PULE PARA LINHA 56

 Client client = new Client("Client-1", "000.000.000-01", "00 0 0000-0000", "123"); 
 client.setAddress(new Address("ADE", "VV", "VFE", "BBBB", "000-00", "C00"));
 client.setSale(new Sale(01.00));  
 client.setCreatedAt(new Date()); - IMPLANTADO NO DAO! 
 ClientDAO.save(client);
 
 ClientCPTpassw clientCPTpassw = new ClientCPTpassw();
 clientCPTpassw.ctpconcret();

 Product product = new Product("YYY", 01.0, 01.0);
 Sale sale = new Sale(01.0);
 product.setSale(sale);
 ProductDAO.save(product);

 Sale sale = new Sale(02.0);
 Employee employee = new Employee("FFF", "000.000.000-02", "AAA", "000");
 sale.setEmployee(employee);
 SaleDAO.save(sale);

 Client client = ClientDAO.findById(1);
     System.out.println("Este é o cliente de ID: \n" +
     client.getId()  
     +"\n----------------------\n" +
     "Com nome: \n" +
     client.getName() 
     +"\n----------------------\n" 
     );

 Client client = ClientDAO.findById(1);
 client.setCpf("000.000.000-00");
 client.setName("Client-1");
 client.setPhone("00 0 0000-0000");
 ClientDAO.update(client);

 Client client = ClientDAO.findById(1);
 ClientDAO.remove(1);

 List<Client> clients = ClientDAO.list();
 System.out.println("Listagem dos: \n" + clients);
 for(Client client : clients){
     System.out.println(client);
}


 EmployeeCPTpassw employeeCPTpassw = new EmployeeCPTpassw();
  List<Employee> employees = employeeCPTpassw.list();
        employees.forEach(empy -> {
             System.out.println(c.getCode());
             System.out.println(empy.getName());
             System.out.println(c.getEmail());
             System.out.println("> " + empy.getPassword());
             try {
                 empy.setPassword("123");
                 System.out.println("> " + empy.getPassword());
                 employeeCPTpassw.update(empy);
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
         });

 ClientCPTpassw clientCPTpassw = new ClientCPTpassw();
 List<Client> clients = clientCPTpassw.list();
         clients.forEach(empy -> {
             System.out.println(c.getCode());
             System.out.println(empy.getName());
             System.out.println(c.getEmail());
             System.out.println("> " + empy.getPassword());
             try {
                 empy.setPassword("123");
                 System.out.println("> " + empy.getPassword());
                 clientCPTpassw.update(empy);
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
         });

List<Client> clients = ClientDAO.findByName("f");
System.out.println("Consultado: " + clients);

ConnectionFactory.close();
    }
}



