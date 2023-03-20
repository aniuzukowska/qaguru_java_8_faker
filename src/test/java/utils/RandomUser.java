package utils;
import com.github.javafaker.Faker;
import tests.TestData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomUser {
    TestData testData = new TestData();
    public static Faker faker = new Faker(new Locale("en"));

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        return faker.options().option(testData.genders);
    }

    public String getRandomPhone() {
        return ("7" + faker.number().randomNumber(9, true));
    }

    public String getRandomBirthDay(String value) {
        Date birthDay = faker.date().birthday(17, 60);
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd", Locale.ENGLISH);
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat sdfYear = new SimpleDateFormat("y", Locale.ENGLISH);

        return switch (value) {
            case "day" -> sdfDay.format(birthDay);
            case "month" -> sdfMonth.format(birthDay);
            case "year" -> sdfYear.format(birthDay);
            default -> throw new IllegalArgumentException("Некорреткное значение. Укажите: day, month или year");
        };
    }

    public String getRandomSubject() {
        return faker.options().option(testData.subjects);
    }

    public String getRandomHobby() {
        return faker.options().option(testData.hobbies);
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomState() {
        return faker.options().option(testData.states);
    }

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option(testData.ncrCities);
            case "Uttar Pradesh" -> faker.options().option(testData.uttarPradeshCities);
            case "Haryana" -> faker.options().option(testData.haryanaCities);
            case "Rajasthan" -> faker.options().option(testData.rajasthanCities);
            default -> throw new IllegalArgumentException("Указано некорректное наименование штата!");
        };
    }
}

