package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Item item){
        if(item.getId() == null){
            System.out.println("item = " + item.getName());
            System.out.println("item = " + item.getPrice());
            System.out.println("item = " + item.getStockQuantity());
            System.out.println("item = " + item.getCategories());
            em.persist(item);
            System.out.println("ItemRepository.save");
        } else {
            em.merge(item);
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
