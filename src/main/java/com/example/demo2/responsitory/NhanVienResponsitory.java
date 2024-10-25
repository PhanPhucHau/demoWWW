package com.example.demo2.responsitory;

import com.example.demo2.resource.model.Nhanvien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class NhanVienResponsitory {
    @PersistenceContext(unitName = "hau")
    private EntityManager entityManager;

    public void persist(Nhanvien nhanvien){
        entityManager.persist(nhanvien);
    }

    public List<Nhanvien> findAll(){
        return entityManager.createNamedQuery("findAll").getResultList();
    }

    public boolean delete(int id){
        Nhanvien nh = entityManager.find(Nhanvien.class, id);
        if (nh != null){
            entityManager.remove(nh);
            return true;
        }
       return false;
    }
}
