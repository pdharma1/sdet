describe("Spying", function () {

    beforeEach(function () {
        number1 = 10;
        number2 = -15;
        number3 = "10 a";
    });

    it("Checking positive numbers return true", function () {
        expect(validateNumber(number1)).toBeTruthy();
    });

    it("Checking negative numbers return false", function () {
        expect(validateNumber(number2)).toBeFalsy();
    });

    it("Checking a NaN", function () {
        expect(isNaN(validateNumber(number3)));
    });
});
