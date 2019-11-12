package eu.epitech.cashmanager.service;

import eu.epitech.cashmanager.domain.Bill;
import eu.epitech.cashmanager.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> getAllBills(int userId) {
        return new ArrayList<>(this.billRepository.findByUserId(userId));
    }

    public Bill getBill(int id) {
        return this.billRepository
                .findById(id)
                .orElse(null);
    }

    public void addBill(int userId, Bill bill) {
        this.billRepository.save(bill);
    }

    public void updateBill(Bill bill) {
        this.billRepository.save(bill);
    }

    public void deleteBill(int id) {
        this.billRepository.deleteById(id);
    }
}
