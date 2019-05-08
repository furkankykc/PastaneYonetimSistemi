package XmlOperations;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import Entity.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class XML {
    public static void main(String[] args) {
        String path = "/Users/furkankykc/Desktop/xmlfile.xml";
        read(path);
//        write(path);
    }

    public static Document read(String path) {
        Document doc = null;
        try {
            File xmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            readUsers(doc);
            readProducts(doc);
            System.out.println(readTables(doc));
        } catch (Exception e) {
            System.exit(0);
        }
        return doc;
    }

    public static void write(String xmlFilePath) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("pastaneOtomasyonSistemi");
            document.appendChild(root);

            Product product = new Product("Meyve suyu", "", 12);
            Product product1 = new Product("hosaf suyu", "", 23);
            Product product2 = new Product("Kayisi suyu23", "", 34);
            Product product3 = new Product("Kola suyu", "", 45);

            ArrayList<Product> productList = new ArrayList<>();
            productList.add(product);
            productList.add(product1);
            productList.add(product2);
            productList.add(product3);
            Table table = new Table(12, productList, 2345);
            Employee employee = new Employee();
            Admin admin = new Admin();
            User user = new User("hilal", "123456", "hilal", "erdur", new Long(213456), new Long(234567));

            // employee element
            Element users = document.createElement("Users");
            Element products = document.createElement("Products");
            Element tables = document.createElement("Tables");
            Element emploies = document.createElement("Emploies");
            Element admins = document.createElement("Admins");


            users.appendChild(writeUser(document, user));
            products.appendChild(writeProducts(document, product));
            tables.appendChild(writeTable(document, table));
            emploies.appendChild(writeEmployee(document,employee));
            admins.appendChild(writeAdmin(document,admin));


            root.appendChild(users);
            root.appendChild(products);
            root.appendChild(tables);
            root.appendChild(emploies);
            root.appendChild(admins);
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (
                TransformerException | ParserConfigurationException tfe) {
            tfe.printStackTrace();
        }
    }


    public static ArrayList<User> readUsers(Document document) {
        ArrayList<User> userList = new ArrayList<>();
        NodeList users = document.getElementsByTagName("User");
        for (int temp = 0; temp < users.getLength(); temp++) {
            Node nNode = users.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                userList.add(new User(eElement.getElementsByTagName("username").item(0).getTextContent(),
                        eElement.getElementsByTagName("password").item(0).getTextContent(),
                        eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("surname").item(0).getTextContent(),
                        new Long(eElement.getElementsByTagName("tc_number").item(0).getTextContent()),
                        new Long(eElement.getElementsByTagName("phone_number").item(0).getTextContent())
                ));
            }
        }

        return userList;
    }

    public static ArrayList<Employee> readEmploies(Document document) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        NodeList emploies = document.getElementsByTagName("Employee");
        for (int temp = 0; temp < emploies.getLength(); temp++) {
            Node nNode = emploies.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                employeeList.add(new Employee(eElement.getElementsByTagName("username").item(0).getTextContent(),
                        eElement.getElementsByTagName("password").item(0).getTextContent(),
                        eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("surname").item(0).getTextContent(),
                        new Long(eElement.getElementsByTagName("tc_number").item(0).getTextContent()),
                        new Long(eElement.getElementsByTagName("phone_number").item(0).getTextContent()),
                        Integer.valueOf(eElement.getElementsByTagName("salary").item(0).getTextContent())
                ));
            }
        }

        return employeeList;
    }

    public static ArrayList<Admin> readAdmin(Document document) {
        ArrayList<Admin> adminList = new ArrayList<>();
        NodeList admin = document.getElementsByTagName("Admin");
        for (int temp = 0; temp < admin.getLength(); temp++) {
            Node nNode = admin.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                adminList.add(new Admin(eElement.getElementsByTagName("username").item(0).getTextContent(),
                        eElement.getElementsByTagName("password").item(0).getTextContent(),
                        eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("surname").item(0).getTextContent(),
                        new Long(eElement.getElementsByTagName("tc_number").item(0).getTextContent()),
                        new Long(eElement.getElementsByTagName("phone_number").item(0).getTextContent()),
                        Boolean.valueOf(eElement.getElementsByTagName("yetki").item(0).getTextContent())
                ));
            }
        }

        return adminList;
    }

    public static ArrayList<Menu> readMenu(Document document) {
        ArrayList<Menu> menuList = new ArrayList<>();
        NodeList menus = document.getElementsByTagName("Menu");
        for (int temp = 0; temp < menus.getLength(); temp++) {
            Node nNode = menus.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                menuList.add(new Menu(eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("content").item(0).getTextContent(),
                        eElement.getElementsByTagName("path").item(0).getTextContent(),
                        Integer.valueOf(eElement.getElementsByTagName("price").item(0).getTextContent())
                ));
            }
        }

        return menuList;
    }

    public static ArrayList<Material> readMaterials(Document document) {
        ArrayList<Material> materialList = new ArrayList<>();
        NodeList materials = document.getElementsByTagName("Material");
        for (int temp = 0; temp < materials.getLength(); temp++) {
            Node nNode = materials.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                materialList.add(new Material(eElement.getElementsByTagName("name").item(0).getTextContent(),
                        Integer.valueOf(eElement.getElementsByTagName("price").item(0).getTextContent())
                ));
            }
        }

        return materialList;
    }

    public static ArrayList<Patisserie> readPatisserries(Document document) {
        ArrayList<Patisserie> patisserieList = new ArrayList<>();
        NodeList patisseries = document.getElementsByTagName("Patisserie");
        for (int temp = 0; temp < patisseries.getLength(); temp++) {
            Node nNode = patisseries.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                patisserieList.add(new Patisserie(readMenu(nNode.getOwnerDocument()),
                        readCakes(nNode.getOwnerDocument()),
                        readEmploies(nNode.getOwnerDocument()),
                        readTables(nNode.getOwnerDocument()),
                        readReservations(nNode.getOwnerDocument()),
                        readAdmin(nNode.getOwnerDocument())

                        ));
            }
        }

        return patisserieList;
    }

    public static ArrayList<Product> readProducts(Document document) {
        ArrayList<Product> productList = new ArrayList<>();
        NodeList products = document.getElementsByTagName("Product");
        for (int temp = 0; temp < products.getLength(); temp++) {
            Node nNode = products.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                productList.add(new Product(eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("image_path").item(0).getTextContent(),
                        Integer.valueOf(eElement.getElementsByTagName("price").item(0).getTextContent())
                ));
            }
        }
        return productList;
    }

    public static ArrayList<Food> readFoods(Document document) {
        ArrayList<Food> foodList = new ArrayList<>();
        NodeList foods = document.getElementsByTagName("Food");
        for (int temp = 0; temp < foods.getLength(); temp++) {
            Node nNode = foods.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                foodList.add(new Food(eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("image_path").item(0).getTextContent(),
                        Integer.valueOf(eElement.getElementsByTagName("price").item(0).getTextContent())
                ));
            }
        }
        return foodList;
    }

    public static ArrayList<Drink> readDrinks(Document document) {
        ArrayList<Drink> drinkList = new ArrayList<>();
        NodeList drinks = document.getElementsByTagName("Drink");
        for (int temp = 0; temp < drinks.getLength(); temp++) {
            Node nNode = drinks.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                drinkList.add(new Drink(eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("image_path").item(0).getTextContent(),
                        Integer.valueOf(eElement.getElementsByTagName("price").item(0).getTextContent())
                ));
            }
        }
        return drinkList;
    }

    public static ArrayList<Table> readTables(Document document) {
        ArrayList<Table> tableList = new ArrayList<>();
        NodeList tables = document.getElementsByTagName("Table");
        for (int temp = 0; temp < tables.getLength(); temp++) {
            Node nNode = tables.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                tableList.add(new Table(Integer.valueOf(eElement.getElementsByTagName("number").item(0).getTextContent()),
                        readProducts(nNode.getOwnerDocument()),
                        Integer.valueOf(eElement.getElementsByTagName("count").item(0).getTextContent())
                ));
            }
        }
        return tableList;
    }

    public static ArrayList<Dealer> readDealer(Document document) {
        ArrayList<Dealer> dealerList = new ArrayList<>();
        NodeList dealer = document.getElementsByTagName("Dealer");
        for (int temp = 0; temp < dealer.getLength(); temp++) {
            Node nNode = dealer.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                dealerList.add(new Dealer(eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("address").item(0).getTextContent(),
                        readPatisserries(nNode.getOwnerDocument()
                        )));
            }
        }
        return dealerList;
    }

    public static ArrayList<DailyLog> readDailyLog(Document document) {
        ArrayList<DailyLog> dailyLogList = new ArrayList<>();
        NodeList dailyLogs = document.getElementsByTagName("DailyLog");
        for (int temp = 0; temp < dailyLogs.getLength(); temp++) {
            Node nNode = dailyLogs.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                dailyLogList.add(new DailyLog(readProducts(nNode.getOwnerDocument())));
            }
        }
        return dailyLogList;
    }

    public static ArrayList<Cake> readCakes(Document document) {
        ArrayList<Cake> cakeList = new ArrayList<>();
        NodeList cakes = document.getElementsByTagName("Cake");
        for (int temp = 0; temp < cakes.getLength(); temp++) {
            Node nNode = cakes.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                cakeList.add(new Cake(eElement.getElementsByTagName("name").item(0).getTextContent(),
                        readMaterials(nNode.getOwnerDocument()),
                        eElement.getElementsByTagName("picture_path").item(0).getTextContent(),
                        Integer.valueOf(eElement.getElementsByTagName("price").item(0).getTextContent()),
                        Integer.valueOf(eElement.getElementsByTagName("size").item(0).getTextContent())
                ));
            }
        }
        return cakeList;
    }

    public static ArrayList<Order> readOrder(Document document) {
        ArrayList<Order> orderList = new ArrayList<>();
        NodeList orders = document.getElementsByTagName("Order");
        for (int temp = 0; temp < orders.getLength(); temp++) {
            Node nNode = orders.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                orderList.add(new Order(readProducts(nNode.getOwnerDocument()),
                        eElement.getElementsByTagName("address").item(0).getTextContent(),
                        new Date(eElement.getElementsByTagName("time").item(0).getTextContent())
                ));
            }
        }
        return orderList;
    }

    public static ArrayList<Reservation> readReservations(Document document) {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        NodeList reservations = document.getElementsByTagName("Reservation");
        for (int temp = 0; temp < reservations.getLength(); temp++) {
            Node nNode = reservations.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                reservationList.add(new Reservation(
                        readTables(nNode.getOwnerDocument()).get(0),
                        eElement.getElementsByTagName("saat").item(0).getTextContent()
                ));
            }
        }
        return reservationList;
    }


    public static Element writeUser(Document document, User user) {
        Element element = null;
        try {

            element = document.createElement("User");

            Element username = document.createElement("username");
            Element password = document.createElement("password");
            Element name = document.createElement("name");
            Element tc_number = document.createElement("tc_number");
            Element surname = document.createElement("surname");
            Element phone_number = document.createElement("phone_number");

            username.appendChild(document.createTextNode(user.getUsername()));
            password.appendChild(document.createTextNode(user.getPassword()));
            name.appendChild(document.createTextNode(user.getName()));
            surname.appendChild(document.createTextNode(user.getSurname()));
            tc_number.appendChild(document.createTextNode(String.valueOf(user.getTc_number())));
            phone_number.appendChild(document.createTextNode(String.valueOf(user.getPhone_number())));

            element.appendChild(username);
            element.appendChild(password);
            element.appendChild(name);
            element.appendChild(surname);
            element.appendChild(phone_number);
            element.appendChild(tc_number);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeEmployee(Document document, Employee employee) {
        Element element = null;
        try {

            element = document.createElement("Employee");

            Element username = document.createElement("username");
            Element password = document.createElement("password");
            Element name = document.createElement("name");
            Element tc_number = document.createElement("tc_number");
            Element surname = document.createElement("surname");
            Element phone_number = document.createElement("phone_number");
            Element salary = document.createElement("salary");

            username.appendChild(document.createTextNode(employee.getUsername()));
            password.appendChild(document.createTextNode(employee.getPassword()));
            name.appendChild(document.createTextNode(employee.getName()));
            surname.appendChild(document.createTextNode(employee.getSurname()));
            tc_number.appendChild(document.createTextNode(String.valueOf(employee.getTc_number())));
            phone_number.appendChild(document.createTextNode(String.valueOf(employee.getPhone_number())));
            salary.appendChild(document.createTextNode(String.valueOf(employee.getSalary())));

            element.appendChild(username);
            element.appendChild(password);
            element.appendChild(name);
            element.appendChild(surname);
            element.appendChild(phone_number);
            element.appendChild(tc_number);
            element.appendChild(salary);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeAdmin(Document document, Admin admin) {
        Element element = null;
        try {

            element = document.createElement("Admin");

            Element username = document.createElement("username");
            Element password = document.createElement("password");
            Element name = document.createElement("name");
            Element tc_number = document.createElement("tc_number");
            Element surname = document.createElement("surname");
            Element phone_number = document.createElement("phone_number");
            Element yetki = document.createElement("yetki");

            username.appendChild(document.createTextNode(admin.getUsername()));
            password.appendChild(document.createTextNode(admin.getPassword()));
            name.appendChild(document.createTextNode(admin.getName()));
            surname.appendChild(document.createTextNode(admin.getSurname()));
            tc_number.appendChild(document.createTextNode(String.valueOf(admin.getTc_number())));
            phone_number.appendChild(document.createTextNode(String.valueOf(admin.getPhone_number())));
            phone_number.appendChild(document.createTextNode(String.valueOf(admin.isYetki())));

            element.appendChild(username);
            element.appendChild(password);
            element.appendChild(name);
            element.appendChild(surname);
            element.appendChild(phone_number);
            element.appendChild(tc_number);
            element.appendChild(yetki);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeMenu(Document document, Menu menu) {
        Element element = null;
        try {

            element = document.createElement("Menu");

            Element name = document.createElement("name");
            Element content = document.createElement("content");
            Element path = document.createElement("path");
            Element price = document.createElement("price");

            name.appendChild(document.createTextNode(menu.getName()));
            content.appendChild(document.createTextNode(menu.getContent()));
            path.appendChild(document.createTextNode(menu.getPath()));
            price.appendChild(document.createTextNode(String.valueOf(menu.getPrice())));

            element.appendChild(name);
            element.appendChild(content);
            element.appendChild(path);
            element.appendChild(price);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeMaterial(Document document, Material material) {
        Element element = null;
        try {

            element = document.createElement("Material");

            Element name = document.createElement("name");
            Element price = document.createElement("price");

            name.appendChild(document.createTextNode(material.getName()));
            price.appendChild(document.createTextNode(String.valueOf(material.getPrice())));

            element.appendChild(name);
            element.appendChild(price);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writePatisserie(Document document, Patisserie patisserie) {
        Element element = null;
        try {

            element = document.createElement("Patisserie");

            Element menus = document.createElement("menus");
            Element cakes = document.createElement("cakes");
            Element emploies = document.createElement("emploies");
            Element tables = document.createElement("tables");
            Element reservations = document.createElement("reservations");
            Element admins = document.createElement("admins");

            for (Menu menu:patisserie.getMenus()) {
                    writeMenu(document,menu);
            }
            for (Cake cake:patisserie.getCakes()) {
                    writeCake(document,cake);
            }
            for (Employee employee:patisserie.getEmploies()) {
                    writeEmployee(document,employee);
            }
            for (Table table:patisserie.getTables()) {
                    writeTable(document,table);
            }
            for (Reservation reservation:patisserie.getReservations()) {
                    writeReservation(document,reservation);
            }
            for (Admin admin:patisserie.getAdmins()) {
                    writeAdmin(document,admin);
            }

            element.appendChild(menus);
            element.appendChild(cakes);
            element.appendChild(emploies);
            element.appendChild(tables);
            element.appendChild(reservations);
            element.appendChild(admins);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeProducts(Document document, Product product) {
        Element element = null;
        try {
            element = document.createElement("Product");

            Element name = document.createElement("name");
            Element image_path = document.createElement("image_path");
            Element price = document.createElement("price");

            name.appendChild(document.createTextNode(product.getName()));
            image_path.appendChild(document.createTextNode(product.getImage_path()));
            price.appendChild(document.createTextNode(String.valueOf(product.getPrice())));

            element.appendChild(name);
            element.appendChild(image_path);
            element.appendChild(price);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeFood(Document document, Food food) {
        Element element = null;
        try {
            element = document.createElement("Food");

            Element name = document.createElement("name");
            Element image_path = document.createElement("image_path");
            Element price = document.createElement("price");

            name.appendChild(document.createTextNode(food.getName()));
            image_path.appendChild(document.createTextNode(food.getImage_path()));
            price.appendChild(document.createTextNode(String.valueOf(food.getPrice())));

            element.appendChild(name);
            element.appendChild(image_path);
            element.appendChild(price);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeDrink(Document document, Drink drink) {
        Element element = null;
        try {
            element = document.createElement("Drink");

            Element name = document.createElement("name");
            Element image_path = document.createElement("image_path");
            Element price = document.createElement("price");

            name.appendChild(document.createTextNode(drink.getName()));
            image_path.appendChild(document.createTextNode(drink.getImage_path()));
            price.appendChild(document.createTextNode(String.valueOf(drink.getPrice())));

            element.appendChild(name);
            element.appendChild(image_path);
            element.appendChild(price);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeTable(Document document, Table table) {
        Element element = null;
        try {
            element = document.createElement("Table");

            Element number = document.createElement("number");
            Element products = document.createElement("products");
            Element count = document.createElement("count");

            number.appendChild(document.createTextNode(String.valueOf(table.getNumber())));
            count.appendChild(document.createTextNode(String.valueOf(table.getCount())));

            for (Product product : table.getProducts()) {
                products.appendChild(writeProducts(document, product));
            }
            element.appendChild(number);
            element.appendChild(count);
            element.appendChild(products);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeDealer(Document document, Dealer dealer) {
        Element element = null;
        try {
            element = document.createElement("Dealer");

            Element name = document.createElement("name");
            Element address = document.createElement("address");
            Element patiserries = document.createElement("patiserries");

            name.appendChild(document.createTextNode(String.valueOf(dealer.getName())));
            address.appendChild(document.createTextNode(String.valueOf(dealer.getAddress())));

            for (Patisserie patisserie : dealer.getPatisseries()) {
                patiserries.appendChild(writePatisserie(document, patisserie));
            }
            element.appendChild(name);
            element.appendChild(address);
            element.appendChild(patiserries);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeDailyLog(Document document, DailyLog dailyLog) {
        Element element = null;
        try {
            element = document.createElement("DailyLog");

            Element products = document.createElement("products");

            for (Product product : dailyLog.getProducts()) {
                products.appendChild(writeProducts(document, product));
            }
            element.appendChild(products);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeCake(Document document, Cake cake) {
        Element element = null;
        try {
            element = document.createElement("Cake");

            Element name = document.createElement("name");
            Element materials = document.createElement("materials");
            Element picturePath = document.createElement("picturePath");
            Element price = document.createElement("price");
            Element size = document.createElement("size");

            name.appendChild(document.createTextNode(String.valueOf(cake.getName())));
            price.appendChild(document.createTextNode(String.valueOf(cake.getPrice())));
            size.appendChild(document.createTextNode(String.valueOf(cake.getSize())));
            picturePath.appendChild(document.createTextNode(cake.getImage_path()));


            for (Material material : cake.getMaterials()) {
                materials.appendChild(writeMaterial(document, material));
            }
            element.appendChild(name);
            element.appendChild(materials);
            element.appendChild(picturePath);
            element.appendChild(price);
            element.appendChild(size);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeOrder(Document document, Order order) {
        Element element = null;
        try {
            element = document.createElement("Order");

            Element address = document.createElement("address");
            Element products = document.createElement("products");
            Element time = document.createElement("time");

            address.appendChild(document.createTextNode(String.valueOf(order.getAddress())));
            time.appendChild(document.createTextNode(String.valueOf(order.getTime())));

            for (Product product : order.getProducts()) {
                products.appendChild(writeProducts(document, product));
            }
            element.appendChild(address);
            element.appendChild(time);
            element.appendChild(products);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static Element writeReservation(Document document, Reservation reservation) {
        Element element = null;
        try {
            element = document.createElement("Reservation");

            Element table = document.createElement("table");
            Element hour = document.createElement("hour");

            hour.appendChild(document.createTextNode(String.valueOf(reservation.getHour())));


            table.appendChild(writeTable(document, reservation.getTable()));

            element.appendChild(table);
            element.appendChild(hour);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }


}
