package progects.atm.models

import java.text.DecimalFormat


data class Account (val customerNumber: Int, var pinNumber: Int) {

    var checkingBalance : Double = 0.0
    private set

    var savingBalance : Double = 0.0
    private set

    private var moneyFormat = DecimalFormat("'$'###,##0.00")

    fun calcCheckingWithdraw(amount: Double) : Double {
        checkingBalance -= amount
        return checkingBalance
    }
    fun calcSavingWithdraw(amount: Double) : Double {
        savingBalance -= amount
        return savingBalance
    }

    fun calcCheckingDeposit(amount: Double) : Double {
        checkingBalance += amount
        return checkingBalance
    }
    fun calcSavingDeposit(amount: Double) : Double {
        savingBalance += amount
        return savingBalance
    }

   fun getCheckingWithdraw() {
       println("Текущий баланс счета: ${moneyFormat.format(checkingBalance)}")
       print("Сумма, которую вы хотите снять с текущего счета: ")
       var amount = readLine()!!.toDouble()
       if (checkingBalance - amount >= 0 ){
           calcCheckingWithdraw(amount)
       }

   }

    fun getCheckingDeposit() {
        println("Текущий баланс счета: ${moneyFormat.format(checkingBalance)}")
        print("Сумма, которую вы хотите снять с текущего счета: ")
        var amount = readLine()!!.toDouble()
        if (checkingBalance + amount >= 0 ){
            calcCheckingDeposit(amount)
        }
    }

    fun getSavingWithdraw() {
        println("Текущий баланс счета: ${moneyFormat.format(savingBalance)}")
        print("Сумма, которую вы хотите снять с текущего счета: ")
        var amount = readLine()!!.toDouble()
        if (savingBalance - amount >= 0 ){
            calcSavingWithdraw(amount)
        }
    }

    fun getSavingDeposit() {
        println("Текущий баланс счета: ${moneyFormat.format(savingBalance)}")
        print("Сумма, которую вы хотите снять с текущего счета: ")
        var amount = readLine()!!.toDouble()
        if (savingBalance + amount >= 0 ){
            calcSavingDeposit(amount)
        }
    }

}
