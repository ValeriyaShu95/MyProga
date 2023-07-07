package com.proga.MyProga.controllers;

import com.proga.MyProga.models.Bill;
import com.proga.MyProga.models.Transaction;
import com.proga.MyProga.models.Users;
import com.proga.MyProga.repo.BillRepository;
import com.proga.MyProga.repo.TransactionRepository;
import com.proga.MyProga.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class MainController {


    private UsersRepository usersRepository;
    private BillRepository billRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public MainController(UsersRepository usersRepository, BillRepository billRepository, TransactionRepository transactionRepository) {
        this.usersRepository = usersRepository;
        this.billRepository = billRepository;
        this.transactionRepository = transactionRepository;
    }


    @GetMapping("/")
    public String home() {
        return "progas";
    }

//    @GetMapping("/progas")
//    public String home(Model model) {
//        Iterable<Users> database = usersRepository.findAll();
//        model.addAttribute("database", database);
////        model.addAttribute("title", "Главная страница");
//        model.addAttribute("name", "LERA");
//        return "progas";
//    }
//
//    @GetMapping("/user/{id}")
//    public String userAdd(@PathVariable(value = "id") long id, Model model) {
//        Optional<Users> database = usersRepository.findById(id);
//        ArrayList<Users> res = new ArrayList<>();
//        database.ifPresent(res::add);
//        model.addAttribute("database", res);
//        return "userGetInformation";
//    }


    @GetMapping("/user/max-age")
    public String getUserWithMaxAge(Model model) {
        Users users = usersRepository.findUserWithMaxAge();
        model.addAttribute("users", users);
        return "users-details";
    }

    @GetMapping("/user/min-age")
    public String getUserWithMinAge(Model model) {
        Users users = usersRepository.findUserWithMinAge();
        model.addAttribute("users", users);
        return "users-details";
    }

    @GetMapping("/user/avg-age")
    public String getUserWithAvgAge(Model model) {
        float database = usersRepository.findUserAverageAge();
        model.addAttribute("title", database);
        return "user-average";
        //"user-average";
    }


    @GetMapping("/user/avg-more-then-age")
    public String getUserWithAgeMoreThenAvr(Model model) {
        List<Users> users = usersRepository.findUserWithAgeMoreThenAvr();
        model.addAttribute("users", users);
        return "users-moreThen";
        //"users-average";
    }

    @GetMapping("/user/max")
    public String userMax(String name, Long id, int age, Model model) {
        Users users = new Users(id, name, age);
        usersRepository.save(users);
        return "users-details";
    }


    @GetMapping("/user/add")
    public String userAdd(Model model) {
        return "userAdd";
    }

    @PostMapping("/user/add")
    public String userPostAdd(Model model, @RequestParam String name, @RequestParam Long id, @RequestParam int age) {
        System.out.println(2);
        Users users = new Users(id, name, age);
        usersRepository.save(users);
        return "sucsess";
    }

    @GetMapping("/bill/add")
    public String billAdd(Model model) {
        return "billAdd";
    }

    @PostMapping("/bill/add")
    public String billPostAdd(@RequestParam float ammount, @RequestParam long userId, Model model) {
        System.out.println(1);
        Optional<Users> database = usersRepository.findById(userId);
        if (database.isPresent()) {
            Bill bill = new Bill(ammount, database.get());
            billRepository.save(bill);
        }
        return "sucsess";
    }



    @GetMapping("/transaction/make")
    public String transactionMake(Model model) {
        return "transactionMake";
    }

    @PostMapping("/transaction/make")
    @Transactional
    public String transactionMake(@RequestParam Long billFromId, @RequestParam Long billToId, @RequestParam float amount) {
        Optional<Bill> billFrom = billRepository.findById(billFromId);
        Optional<Bill> billTo = billRepository.findById(billToId);
        if ((billFrom.isPresent()) && (billTo.isPresent())) {
            Transaction transaction = new Transaction(amount, billFromId, billToId);
            transactionRepository.save(transaction);
            billFrom.get().setAmmount(billFrom.get().getAmmount() - amount);
            billTo.get().setAmmount(billTo.get().getAmmount() + amount);
            return "sucsess";
        } else {
            return "На счете недостаточно средств";
        }
    }


        @GetMapping("/deposit/make")
        public String depositnMake(Model model) {
            return "depositMake";
        }
        @PostMapping("/deposit/make")
        @Transactional
        public String depositMake(@RequestParam Long billToId, @RequestParam float amount) {
            Optional<Bill> billTo = billRepository.findById(billToId);
            if (billTo.isPresent()) {
                Transaction transaction = new Transaction(amount, billToId);
                transactionRepository.save(transaction);
                billTo.get().setAmmount(billTo.get().getAmmount() + amount);
                return "sucsess";
            }else {
                return "На счете недостаточно средств";
            }



//        @GetMapping("/deposit/make")
//        bill save
    }



//    @PostMapping("/transfer")
//    public ResponseEntity<String> transferAmount(@RequestBody TransferRequest transferRequest) {
//        // Получение счетов по идентификаторам
//        Transaction fromBill = transactionRepository.findById(transferRequest.getFromTrandsctionId()).orElse(null);
//        Account toAccount = accountRepository.findById(transferRequest.getToAccountId()).orElse(null);
//
//        if (fromAccount == null || toAccount == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("One or both accounts not found");
//        }
//
//        if (fromAccount.getBalance() < transferRequest.getAmount()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient funds");
//        }
//
//        // Вычитание суммы с одного счета
//        fromAccount.setBalance(fromAccount.getBalance() - transferRequest.getAmount());
//        accountRepository.save(fromAccount);
//
//        // Добавление суммы на другой счет
//        toAccount.setBalance(toAccount.getBalance() + transferRequest.getAmount());
//        accountRepository.save(toAccount);
//
//        return ResponseEntity.ok("Transfer successful");
//    }

}


//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }