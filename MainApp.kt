package progects.atm

import progects.atm.models.ATM
import progects.atm.models.Account

internal var data = mutableListOf<Account>()

fun main(args: Array<String>) {
    //Загрузить данные аккаунтов
    val c1 = Account(1234567, 9988)
    val c2 = Account(7654321, 8899)

    data.add(c1)
    data.add(c2)
    StringBuilder("gfgf").reverse()
    //Запуск приложения
    ATM(data).start()
}
