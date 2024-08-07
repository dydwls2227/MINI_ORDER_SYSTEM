// 연결확인
package com.jasp.mini_order_system;

import static com.jasp.mini_order_system.Utils.print;

import com.jasp.mini_order_system.entity.Account;
import com.jasp.mini_order_system.entity.Category;
import com.jasp.mini_order_system.entity.Item;
import com.jasp.mini_order_system.entity.Member;
import com.jasp.mini_order_system.entity.Order;
import com.jasp.mini_order_system.repository.AccountRepository;
import com.jasp.mini_order_system.repository.ItemRepository;
import com.jasp.mini_order_system.repository.MemberRepository;
import com.jasp.mini_order_system.repository.OrderRepository;
import com.jasp.mini_order_system.repository.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final Repository<Item> itemRepository = new ItemRepository();
    private static final Repository<Order> orderRepository = new OrderRepository();
    private static final Repository<Member> memberRepository = new MemberRepository();
    private static final Repository<Account> accountRepository = new AccountRepository();

    public static void main(String[] args) {

        // 데이터 초기화
        /*itemDataInit();
        memberAndAccountDataInit();*/

        // 주문 생성
        List<Member> memberList = memberRepository.findAll();
        List<Item> itemList = itemRepository.findAll();

        Random random = new Random();
        List<Order> orderList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Member member = memberList.get(i % memberList.size());
            List<Item> orderItems = new ArrayList<>();

            // 랜덤하게 3~5개의 아이템 추가
            int itemCount = 3 + random.nextInt(3);
            for (int j = 0; j < itemCount; j++) {
                int rIdx = random.nextInt(itemList.size());
                Item item = itemList.get(rIdx);
                orderItems.add(item);
            }

            final Order order = new Order(member, orderItems);
            orderRepository.save(order);
            orderList.add(order);
        }

        // 주문 리스트 출력
        print(orderList);
    }

    /*private static void memberAndAccountDataInit() {
        final Account accountA = new Account("123-456-7890", 3000000); // 3,000,000원
        final Member memberA = new Member("park@mju.ac.kr", "9yz5CT4mLR", "PARK", accountA);
        accountRepository.save(accountA);
        memberRepository.save(memberA);

        final Account accountB = new Account("234-567-8901", 4500000); // 4,500,000원
        final Member memberB = new Member("yoo@mju.ac.kr", "EtZoMf71Z5", "YOO", accountB);
        accountRepository.save(accountB);
        memberRepository.save(memberB);

        final Account accountC = new Account("345-678-9012", 5000000); // 5,000,000원
        final Member memberC = new Member("ha@mju.ac.kr", "sngL54SU5Q", "HA", accountC);
        accountRepository.save(accountC);
        memberRepository.save(memberC);

        final Account accountD = new Account("456-789-0123", 2500000); // 2,500,000원
        final Member memberD = new Member("ko@mju.ac.kr", "HB4NU0yRCF", "KO", accountD);
        accountRepository.save(accountD);
        memberRepository.save(memberD);
    }*/


    /*private static void itemDataInit() {
        final Item laptop = new Item("노트북", 1500000, Category.ELECTRONICS); // 1,500,000원
        itemRepository.save(laptop);
        final Item smartphone = new Item("스마트폰", 900000, Category.ELECTRONICS); // 900,000원
        itemRepository.save(smartphone);
        final Item tablet = new Item("태블릿", 600000, Category.ELECTRONICS); // 600,000원
        itemRepository.save(tablet);
        final Item camera = new Item("카메라", 800000, Category.ELECTRONICS); // 800,000원
        itemRepository.save(camera);
        final Item headphones = new Item("헤드폰", 200000, Category.ELECTRONICS); // 200,000원
        itemRepository.save(headphones);

        final Item jacket = new Item("자켓", 200000, Category.CLOTHING); // 200,000원
        itemRepository.save(jacket);
        final Item jeans = new Item("청바지", 50000, Category.CLOTHING); // 50,000원
        itemRepository.save(jeans);
        final Item tshirt = new Item("티셔츠", 30000, Category.CLOTHING); // 30,000원
        itemRepository.save(tshirt);
        final Item shoes = new Item("운동화", 100000, Category.CLOTHING); // 100,000원
        itemRepository.save(shoes);
        final Item coat = new Item("코트", 250000, Category.CLOTHING); // 250,000원
        itemRepository.save(coat);

        final Item apple = new Item("사과", 2000, Category.GROCERY); // 2,000원
        itemRepository.save(apple);
        final Item milk = new Item("우유", 1500, Category.GROCERY); // 1,500원
        itemRepository.save(milk);
        final Item bread = new Item("빵", 3000, Category.GROCERY); // 3,000원
        itemRepository.save(bread);
        final Item rice = new Item("쌀", 45000, Category.GROCERY); // 45,000원
        itemRepository.save(rice);
        final Item eggs = new Item("달걀", 5000, Category.GROCERY); // 5,000원
        itemRepository.save(eggs);

        final Item chair = new Item("의자", 85000, Category.FURNITURE); // 85,000원
        itemRepository.save(chair);
        final Item table = new Item("테이블", 150000, Category.FURNITURE); // 150,000원
        itemRepository.save(table);
        final Item bed = new Item("침대", 500000, Category.FURNITURE); // 500,000원
        itemRepository.save(bed);
        final Item sofa = new Item("소파", 400000, Category.FURNITURE); // 400,000원
        itemRepository.save(sofa);
        final Item lamp = new Item("램프", 30000, Category.FURNITURE); // 30,000원
        itemRepository.save(lamp);
    }*/

}