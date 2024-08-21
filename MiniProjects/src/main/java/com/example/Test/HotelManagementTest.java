package com.example.Test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.entity.Reservation;

public class HotelManagementTest {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void insertRecord(int reservationNo, String name, String roomNo, String phoneNo, String adharNo,
			String joiningDate, String roomType, int noofDays, int persons, double money) {
		entityManager.getTransaction().begin();
		Reservation reservation = new Reservation(reservationNo, name, roomNo, phoneNo, adharNo, joiningDate, roomType,
				noofDays, persons, money);
		entityManager.persist(reservation);
		System.out.println("Record Inserted Successfully.");
		entityManager.getTransaction().commit();
	}

	public static void viewResevations() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select r from Reservation r");
		List<Reservation> list = query.getResultList();
		System.out.println("Viewing Current Reservations");
		for (Reservation reservation : list) {
			System.out.println(reservation);
		}
		entityManager.getTransaction().commit();
	}

	public static void getRoomNoAndMobileNo(int reservation_id, String name) {
		entityManager.getTransaction().begin();
		Query query = entityManager
				.createQuery("select r from Reservation r where r.reservation_id = :reservation_id and r.name = :name");
		query.setParameter("reservation_id", reservation_id);
		query.setParameter("name", name);
		List<Reservation> list = query.getResultList();
		if (list.isEmpty()) {
			System.out.println("Error : No Reservation found with the given Id and Name ");
		} else {
			System.out.println("Getting Room No and Mobile No based on Reservation Id and Name : ");
			for (Reservation reservation : list) {
				System.out.println(reservation.getRoomNo() + "  " + reservation.getPhoneNo());
			}
		}
		entityManager.getTransaction().commit();
	}

	public static void updateReservation(int reservation_id, String name, String roomNo, int days, String roomType,
			double money) {
		entityManager.getTransaction().begin();
		Reservation reservation = entityManager.find(Reservation.class, reservation_id);
		if (reservation != null) {
			reservation.setName(name);
			reservation.setRoomNo(roomNo);
			reservation.setNoOfDays(days);
			reservation.setRoomType(roomType);
			reservation.setMoney(money);
			System.out.println("Reservation Updated Successfully.");
			System.out.println(reservation);
		} else {
			System.out.println("Error : The reservaton with ID " + reservation_id + " does not exist");
		}
		entityManager.getTransaction().commit();
	}

	public static void deleteReservation(int reservation_id) {
		entityManager.getTransaction().begin();
		Reservation reservation = entityManager.find(Reservation.class, reservation_id);
		if (reservation != null) {
			entityManager.remove(reservation);
			System.out.println("Reservation Deleted Successfully");
		} else {
			System.out.println("Error : The reservaton with ID " + reservation_id + " does not exist");
		}
		entityManager.getTransaction().commit();
	}

	public static void sortingBasedOnMoney() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select r from Reservation r order by r.money desc");
		List<Reservation> list = query.getResultList();
		System.out.println("Sorting Reservation Details based on Money");
		for (Reservation reservation : list) {
			System.out.println(reservation);
		}
		entityManager.getTransaction().commit();
	}

	public static void sortingBasedOnNoOfPersons() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select r from Reservation r order by r.noOfPersons");
		List<Reservation> list = query.getResultList();
		System.out.println("Sorting Reservation Details based on No Of Persons");
		for (Reservation reservation : list) {
			System.out.println(reservation);
		}
		entityManager.getTransaction().commit();
	}

	public static void close() {
		entityManager.close();
		entityManagerFactory.close();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continueRunning = true;
		while(continueRunning) {
			System.out.println("Available Options\n Press");
			System.out.println("1 - Insert Record\n"+"2 - View Reservations\n"+"3 - Get Room No And Mobile Number\n"+"4 - Update Reservation\n"
			+"5 - Delete Reservation\n"+"6 - Sorting Based on Money\n"+"7 - Sorting Based on No Of Persons\n"+"8 - Close Entities\n"+"9 - Exit Program");
			System.out.print("Enter the choice : ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the details to Reserve a Room");
				System.out.println("Resevation Id");
				int id = sc.nextInt();
				System.out.println("Guest Name : ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Room No : ");
				String roomNo = sc.nextLine();
				System.out.println("Phone No : ");
				String phoneNo = sc.nextLine();
				System.out.println("Adhar No : ");
				String adharNo = sc.nextLine();
				System.out.println("Joining Date : ");
				String joiningDate = sc.nextLine();
				System.out.println("Room Type like AC/NON-AC/DELUX/ULTRA-DELUX ...:");
				String roomType = sc.nextLine();
				System.out.println("No of Days : ");
				int days = sc.nextInt();
				System.out.println("No of Persons : ");
				int persons = sc.nextInt();
				System.out.println("Money : ");
				double money = 0;
				if(roomType == "AC")
					money = days*2000;
				else if(roomType == "ULTRA-DELUX")
					money = days * 1500;
				else if(roomType == "DELUX")
					money = days * 1200;
				else
					money = days * 1000;
				insertRecord(id, name, roomNo, phoneNo, adharNo, joiningDate,roomType, days, persons, money);
				break;
			case 2:
				viewResevations();
				break;
			case 3:
				System.out.println("Enter the Reservation_id and Name to search Room No : ");
				int reservation_id = sc.nextInt();
				sc.nextLine();
				String name1 = sc.nextLine();
				getRoomNoAndMobileNo(reservation_id, name1);
				break;
			case 4:
				System.out.println("Enter the Reservation_id to update the details : ");
				int reservation_id1 = sc.nextInt();
				System.out.println("Enter the Details to Update :");
				System.out.print("Name : ");
				sc.nextLine();
				String name2 = sc.nextLine();
				System.out.println("Room No : ");
				String roomNo1 = sc.nextLine();
				System.out.println("Days : ");
				int days1 = sc.nextInt();
				System.out.println("Room Type : ");
				sc.nextLine();
				String roomType1 = sc.nextLine();
				System.out.println("Money : ");
				if(roomType1 == "AC")
					money = days1 * 2000;
				else if(roomType1 == "ULTRA-DELUX")
					money = days1 * 1500;
				else if(roomType1 == "DELUX")
					money = days1 * 1200;
				else
					money = days1 * 1000;
				updateReservation(reservation_id1, name2, roomNo1, days1, roomType1, money);
				break;
			case 5:
				System.out.println("Enter the Reservation_id to Delete Record : ");
				int reservation_id2 = sc.nextInt();
				deleteReservation(reservation_id2);
				break;
			case 6:
				sortingBasedOnMoney();
				break;
			case 7:
				sortingBasedOnNoOfPersons();
				break;
			case 8:
				close();
				break;
			case 9:
				continueRunning = false;
				System.out.println("Exiting the program ....");
				break;
			default:
				System.out.println("Invalid choice. Please choose a valid option");	
			}
		}	

	}

}
