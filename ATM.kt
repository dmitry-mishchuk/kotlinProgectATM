package progects.atm.models

import progects.atm.utils.viewMainMenu
import progects.atm.utils.viewSubMenu

class ATM {
    val accounts: List<Account>
    lateinit var account : Account
    var customerNumber : Int = -1
    var pinNumber : Int = -1

    constructor(accounts: List<Account>){
        this.accounts = accounts
    }

    fun start(){
        var flag = 1
        do {
            //Запустить "Приветствие"
            println("Добро пожаловать в проект ATM!")
            try {
                //Запустить ввод данных и их проверку
                print("Введите номер свой карты: ")
                customerNumber = readLine()!!.toInt()

                print("Введите номер свой карты: ")
                pinNumber = readLine()!!.toInt()
            }catch (e:Exception) {
                start()
            }

            if (customerNumber == 0 && pinNumber == 0){
                stop()
            }
            accounts.forEach {
                if (it.customerNumber == customerNumber && it.pinNumber == pinNumber){
                    println("Проверка пройдена")
                    this.account = it
                    mainMenu(account)
                }
            }
            println("Проверка не пройдена")
        }while (flag == 1)
    }

    fun mainMenu(account : Account){
        viewMainMenu()
        var selection = readLine()!!.toInt()
        when (selection){
            1 -> menuCheckingAccount(account)
            2 -> menuSavingAccount (account)
            3 -> println("Спасибо за использование нашего ATM. ")
            else -> {
                println("Ваш номер не верный!\n")
                mainMenu(account)
            }
        }
    }

    fun menuCheckingAccount(account : Account){
        viewSubMenu("основного")
        var selection = readLine()!!.toInt()
        when (selection){
            1 -> {
                    println("Баланс основного аккаунта ${account.checkingBalance}")
                    menuCheckingAccount(account)
                 }
            2 -> {
                    account.getCheckingWithdraw()
                    menuCheckingAccount(account)
                 }
            3 -> {
                    account.getCheckingDeposit()
                    menuCheckingAccount(account)
                 }
            4 ->    mainMenu(account)
            else -> {
                println("Ваш номер не верный!\n")
                menuCheckingAccount(account)
            }
        }
    }

    fun menuSavingAccount(account : Account){
        viewSubMenu("сберегательного")
        var selection = readLine()!!.toInt()
        when (selection){
            1 -> {
                println("Баланс сберегательного аккаунта ${account.savingBalance}")
                menuCheckingAccount(account)
            }
            2 -> {
                account.getSavingWithdraw()
                menuCheckingAccount(account)
            }
            3 -> {
                account.getSavingDeposit()
                menuCheckingAccount(account)
            }
            4 -> mainMenu(account)
            else -> {
                println("Ваш номер не верный!\n")
                menuSavingAccount(account)
            }
        }
    }

    fun stop(){
        println("Stopping system...")
        System.exit(0)
    }
}
