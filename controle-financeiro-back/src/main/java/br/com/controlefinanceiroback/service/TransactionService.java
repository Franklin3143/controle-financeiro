package br.com.controlefinanceiroback.service;

import br.com.controlefinanceiroback.entity.Transaction;
import br.com.controlefinanceiroback.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Transaction createTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return repository.findById(id);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        return repository.findById(id).map(existing -> {
            existing.setDescription(transaction.getDescription());
            existing.setValue(transaction.getValue());
            existing.setType(transaction.getType());
            existing.setDate(transaction.getDate());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
