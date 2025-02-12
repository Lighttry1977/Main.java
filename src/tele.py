from aiogram import Bot, Dispatcher, types
from aiogram.filters import Command
from aiogram.types import ReplyKeyboardMarkup, KeyboardButton
import asyncio
import os
from dotenv import load_dotenv

# Загружаем переменные окружения
load_dotenv()
KEY_API = os.getenv("KEY_API")

# Проверяем, загружен ли ключ
if not KEY_API:
    raise ValueError("❌ Ошибка: API-ключ не загружен! Проверь .env файл.")

# Создаём бота и диспетчер
bot = Bot(token=KEY_API)
dp = Dispatcher()

# Описание бота (по центру)
DESCRIPTION_TEXT = """Біздің мақсат
Халықаралық этно-кафе желісін құру арқылы біздің ұлттық
кодты болашақ ұрпаққа жеткізу 🌱🇰🇿"""

async def set_bot_description():
    centered_text = DESCRIPTION_TEXT.center(80)
    await bot.set_my_description(centered_text)
    print("✅ Описание бота обновлено!")

# ✅ Создаем клавиатуру (правильная версия)
menu_keyboard = ReplyKeyboardMarkup(
    keyboard=[
        [KeyboardButton(text="Блюда с рыбой"), KeyboardButton(text="Блюда с курицей"), KeyboardButton(text="Блюда с мясом")],
        [KeyboardButton(text="Go Back")],
        [KeyboardButton(text="Дополнительная кнопка 1"), KeyboardButton(text="Дополнительная кнопка 2")],
        [KeyboardButton(text="Дополнительная кнопка 3")]
    ],
    resize_keyboard=True
)


# ✅ Обработчик команды /menu (отправляет клавиатуру)
@dp.message(Command("start"))
async def send_menu(message: types.Message):
    await message.answer("Выберите категорию:", reply_markup=menu_keyboard)

# ✅ Обработчик команды /vid (отправляет видео)
@dp.message(Command("vid"))
async def send_video(message: types.Message):
    video = types.FSInputFile("video.mp4")
    await message.answer_video(video, caption="📹 Вот ваше видео!")

# ✅ Запуск бота
async def main():
    await set_bot_description()
    await dp.start_polling(bot)

if __name__ == "__main__":
    asyncio.run(main())

