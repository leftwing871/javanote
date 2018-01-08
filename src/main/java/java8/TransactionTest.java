package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class TransactionTest {



    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //2011년에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리하시오.
        List<Transaction> list01 =
        transactions.stream()
                .filter(j -> j.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        for(Transaction t : list01) {
            System.out.println(t.toString());
        }

        //거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> cities =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        for(String one : cities) {
            System.out.println(one);
        }

        //케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        List<Trader> traders =
                transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        //모든 거래자의 이름을 알파벳순으로 정렬해서 반환하사오.
        String traderStr =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + "," + n2);

        System.out.println(traderStr);
    }
}
