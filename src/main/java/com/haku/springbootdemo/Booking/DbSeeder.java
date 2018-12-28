package com.haku.springbootdemo.Booking;

import com.haku.springbootdemo.Customer.Customer;
import com.haku.springbootdemo.Customer.CustomerRepository;
import com.haku.springbootdemo.User.AppRole;
import com.haku.springbootdemo.User.AppRoleRepository;
import com.haku.springbootdemo.User.AppUser;
import com.haku.springbootdemo.User.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DbSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;
    private CustomerRepository customerRepository;
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    @Autowired
    public DbSeeder(BookingRepository bookingRepository, CustomerRepository customerRepository, AppUserRepository appUserRepository, AppRoleRepository appRoleRepository){
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Marriot", 1200, 3));
        bookings.add(new Booking("W", 1000, 4));
        bookings.add(new Booking("Haku", 1100, 5));
        bookingRepository.saveAll(bookings);


        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "haku"));
        customers.add(new Customer(2, "chihiro"));
        customerRepository.saveAll(customers);

        List<AppUser> appUsers = new ArrayList<>();
        appUsers.add(new AppUser(1, "Haku", "123"));
        appUsers.add(new AppUser(2, "Chihiro", "123"));
        appUserRepository.saveAll(appUsers);

//        AppRole role1 = new AppRole("Admin");
//        AppRole role2 = new AppRole("Manager");
//        AppRole role3 = new AppRole("staff");
//
//
//        Set<AppRole> roleSet1 = new HashSet<AppRole>();
//        roleSet1.add(role1);
//        roleSet1.add(role2);
//        Set<AppRole> roleSet2 = new HashSet<AppRole>();
//        roleSet2.add(role1);
//        roleSet2.add(role3);
//        appRoleRepository.save(role1);
//        appRoleRepository.save(role2);
//        appRoleRepository.save(role3);
//
//        AppUser user1 = new AppUser("Kohaku","123", roleSet1);
//        AppUser user2 = new AppUser("Chihiro","123", roleSet2);
//        appUserRepository.save(user1);
//        appUserRepository.save(user2);



    }
}
