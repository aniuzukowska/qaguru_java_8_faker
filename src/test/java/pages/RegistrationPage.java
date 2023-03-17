package pages;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import pages.components.Calendar;
import com.codeborne.selenide.SelenideElement;


public class RegistrationPage {
    private final Calendar calendar = new Calendar();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyCheckBox = $("#hobbiesWrapper"),
            uploadFileElement = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateField = $("#state"),
            stateValue = $("#stateCity-wrapper"),
            cityField = $("#city"),
            cityValue = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyCheckBox.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFile(String value) {
        uploadFileElement.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateField.click();
        stateValue.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityField.click();
        cityValue.$(byText(value)).click();
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
