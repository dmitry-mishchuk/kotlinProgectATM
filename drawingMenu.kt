package progects.atm.utils

fun viewMainMenu() {
    println("\nВыберите учетную запись, к которой вы хотите получить доступ: ")
    println("Type 1 - Основной аккаунт")
    println("Type 2 - Сберегательный аккаунт")
    println("Type 3 - Выход")
    println("Выберите пожалуйста...")
}
fun viewSubMenu(text:String) {
    println("Меню $text аккаунта")
    println("Type 1 - Баланс")
    println("Type 2 - Снять cредства")
    println("Type 3 - Внести средства")
    println("Type 4 - Выход")
    println("Выберите пожалуйста...")
}