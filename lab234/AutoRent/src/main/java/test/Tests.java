package test;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;
import java.time.*;

public class Tests {

	@Test
	public void checkCarFieldsCorrectness() {
		Car car = new Car();
		car.setId(1);
		car.setCarMark("Toyota");
		car.setCarName("Camri");
		car.setCarPrice(999);
		car.setCarQuality("A");
		car.setStatus(Status.READY);
		assertEquals(car.getId(), 1);
		assertEquals(car.getCarMark(), "Toyota");
		assertEquals(car.getCarName(), "Camri");
		assertEquals(car.getCarPrice(), 999);
		assertEquals(car.getCarQuality(), "A");
	}

	@Test
	public void checkCarEqualsMethod() {
		Car car1 = new Car(1, "Mark 5", "Skoda", "B", 1000, Status.REPAIR);
		Car car2 = new Car(1, "Mark 5", "Skoda", "B", 1000, Status.REPAIR);
		Car car1RefCopy = car1;
		assertTrue(car1.equals(car2));
		assertTrue(car1.equals(car1RefCopy));
	}
	
	@Test
	public void checkCarToStringMethod() {
		Car car = new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR);
		String predictedResult = "Car{id=1, carName='Calina', carMark='Lada', carQuality='S', carPrice=9999, status=REPAIR}";
		assertEquals(car.toString(), predictedResult);
	}
	
	@Test
	public void checkOrderFieldsCorrectness() {
		Order order = new Order();
		LocalDateTime currentDate = LocalDateTime.now();
		order.setId(1);
		order.setCar(new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR));
		order.setUser(new User());
		order.setPassport("12345678");
		order.setWithDriver(true);
		order.setStartTime(currentDate);
		order.setEndTime(currentDate);
		order.setOrderPrice(1000);
		order.setStatus(Status.WAITING);
		order.setPayStatus(Status.UNPAYED);
		order.setDescription("Some description");
		assertEquals(order.getId(), 1);
		assertTrue(order.getCar().equals(new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR)));
		assertTrue(order.getUser().equals(new User()));
		assertEquals(order.getPassport(), "12345678");
		assertEquals(order.getWithDriver(), true);
		assertEquals(order.getStartTime(), currentDate);
		assertEquals(order.getEndTime(), currentDate);
		assertEquals(order.getOrderPrice(), 1000);
		assertEquals(order.getStatus(), Status.WAITING);
		assertEquals(order.getPayStatus(), Status.UNPAYED);
		assertEquals(order.getDescription(), "Some description");
	}

	@Test
	public void checkOrderEqualsMethod() {
		LocalDateTime currentDate = LocalDateTime.now();
		Order order1 = new Order(
				1,
				new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR),
				new User(),
				"12345678",
				true,
				currentDate,
				currentDate,
				9999,
				Status.ACCEPTED,
				Status.PAYED,
				"Sample text"
		);
		Order order2 = new Order(
				1,
				new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR),
				new User(),
				"12345678",
				true,
				currentDate,
				currentDate,
				9999,
				Status.ACCEPTED,
				Status.PAYED,
				"Sample text"
		);
		Order order1RefCopy = order1;
		assertTrue(order1.equals(order2));
		assertTrue(order1.equals(order1RefCopy));
	}
	
	@Test
	public void checkOrderToStringMethod() {
		LocalDateTime currentDate = LocalDateTime.now();
		Order order = new Order(
				1,
				new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR),
				new User(),
				"12345678",
				true,
				currentDate,
				currentDate,
				9999,
				Status.ACCEPTED,
				Status.PAYED,
				"Sample text"
		);
		String predictedResult = "Order{id=1, car=Car{id=1, carName='Calina', carMark='Lada'," +
				" carQuality='S', carPrice=9999, status=REPAIR}, user=User{id=0," +
				" userName='null', email='null', password='null', name='null', lastName='null'," +
				" active=null, role=null}, passport='12345678', withDriver=true," +
				" startTime=" + currentDate.toString() + ", endTime=" + currentDate.toString() + "," +
				" orderPrice=9999, status=ACCEPTED, payStatus=PAYED, description='Sample text'}";
		assertEquals(order.toString(), predictedResult);
	}
	
	@Test
	public void checkRepairFieldsCorrectness() {
		Repair repair = new Repair();
		LocalDateTime currentDate = LocalDateTime.now();
		Order order = new Order(
				1,
				new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR),
				new User(),
				"12345678",
				true,
				currentDate,
				currentDate,
				9999,
				Status.ACCEPTED,
				Status.PAYED,
				"Sample text"
		);
		repair.setId(1);
		repair.setOrder(order);
		repair.setPrice(100000);
		repair.setPayStatus(Status.PAYED);
		assertEquals(repair.getId(), 1);
		assertEquals(repair.getOrder(), order);
		assertEquals(repair.getPrice(), 100000);
		assertEquals(repair.getPayStatus(), Status.PAYED);
	}

	@Test
	public void checkRepairEqualsMethod() {
		LocalDateTime currentDate = LocalDateTime.now();
		Order order = new Order(
				1,
				new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR),
				new User(),
				"12345678",
				true,
				currentDate,
				currentDate,
				9999,
				Status.ACCEPTED,
				Status.PAYED,
				"Sample text"
		);
		Repair rep1 = new Repair(1, order, 100, Status.UNPAYED);
		Repair rep2 = new Repair(1, order, 100, Status.UNPAYED);
		Repair rep1RefCopy = rep1;
		assertTrue(rep1.equals(rep2));
		assertTrue(rep1.equals(rep1RefCopy));
	}
	
	@Test
	public void checkRepairToStringMethod() {
		LocalDateTime currentDate = LocalDateTime.now();
		Order order = new Order(
				1,
				new Car(1, "Calina", "Lada", "S", 9999, Status.REPAIR),
				new User(),
				"12345678",
				true,
				currentDate,
				currentDate,
				9999,
				Status.ACCEPTED,
				Status.PAYED,
				"Sample text"
		);
		Repair rep = new Repair(1, order, 100, Status.UNPAYED);
		String orderString = "Order{id=1, car=Car{id=1, carName='Calina', carMark='Lada'," +
				" carQuality='S', carPrice=9999, status=REPAIR}, user=User{id=0," +
				" userName='null', email='null', password='null', name='null', lastName='null'," +
				" active=null, role=null}, passport='12345678', withDriver=true," +
				" startTime=" + currentDate.toString() + ", endTime=" + currentDate.toString() + "," +
				" orderPrice=9999, status=ACCEPTED, payStatus=PAYED, description='Sample text'}";
		
		String predictedResult = "Repair{id=1, order=" + orderString + ", price=100, payStatus=UNPAYED}";
		assertEquals(rep.toString(), predictedResult);
	}
	
	@Test
	public void checkUserFieldsCorrectness() {
		User user = new User();
		user.setId(1);
		user.setUserName("testUserName");
		user.setEmail("testmail@gmail.com");
		user.setPassword("HashedPassword");
		user.setName("Noname");
		user.setLastName("Noname");
		user.setActive(true);
		user.setRole(Role.USER);
		assertEquals(user.getId(), 1);
		assertEquals(user.getUserName(), "testUserName");
		assertEquals(user.getEmail(), "testmail@gmail.com");
		assertEquals(user.getPassword(), "HashedPassword");
		assertEquals(user.getName(), "Noname");
		assertEquals(user.getLastName(), "Noname");
		assertEquals(user.getActive(), true);
		assertEquals(user.getRole(), Role.USER);
	}

	@Test
	public void checkUserEqualsMethod() {
		User user1 = new User(1, "test", "test", "password", "name", "lastname", true, Role.ADMIN);
		User user2 = new User(1, "test", "test", "password", "name", "lastname", true, Role.ADMIN);
		User user1RefCopy = user1;
		assertTrue(user1.equals(user2));
		assertTrue(user1.equals(user1RefCopy));
	}
	
	@Test
	public void checkUserToStringMethod() {
		User user = new User(1, "test", "test", "password", "name", "lastname", true, Role.ADMIN);
		String predictedResult = "User{id=1, userName='test', email='test', password='password', name='name', lastName='lastname', active=true, role=ADMIN}";
		assertEquals(user.toString(), predictedResult);
	}
	
}
