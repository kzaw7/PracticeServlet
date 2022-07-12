package Dao;

import Model.Reimbursement;

import java.util.List;

public interface ReimbursementDao{
    public int addReimbursement(Reimbursement reimbursment);
    public int resolveReimbursement(Reimbursement reimbursment);
    public Reimbursement getReimbursementByName(String title);
    public Reimbursement getReimbursementByAuthorId(int id);
    public List<Reimbursement> getAllPendingReimbursements();
    public List<Reimbursement> getAllResolvedReimbursements();
    public List<Reimbursement> getAllPendingReimbursementByAuthor(int id);
    public List<Reimbursement> getAllResolvedReimbursementByAuthor(int id);
    public List<Reimbursement> getAllReimbursementsByAuthorId(int id);
}


