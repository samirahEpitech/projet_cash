package eu.epitech.cashmanager.controller;

import eu.epitech.cashmanager.domain.Bill;
import eu.epitech.cashmanager.domain.User;
import eu.epitech.cashmanager.service.BillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value = "/api/users/{userId}/bills", method = RequestMethod.GET)
    public List<Bill> getAllBills(@PathVariable int userId) {
        return this.billService.getAllBills(userId);
    }

    @RequestMapping(value = "/api/users/{userId}/bills/{id}", method = RequestMethod.GET)
    public Bill getBill(@PathVariable int id) {
        return this.billService.getBill(id);
    }

    @RequestMapping(value = "/api/users/{userId}/bills", method = RequestMethod.POST)
    public void addBill(@PathVariable int userId, @RequestBody Bill bill) {
        bill.setUser(new User(userId, "", "", ""));
        this.billService.addBill(userId, bill);
    }

    @RequestMapping(value = "/api/users/{userId}/bills", method = RequestMethod.PUT)
    public void updateBill(@PathVariable int userId, @RequestBody Bill bill) {
        bill.setUser(new User(userId, "", "", ""));
        this.billService.updateBill(bill);
    }

    @RequestMapping(value = "/api/users/{userId}/bills/{id}", method = RequestMethod.DELETE)
    public void deleteBill(@PathVariable int id) {
        this.billService.deleteBill(id);
    }
}
