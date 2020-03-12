package seedu.address.model.pet;

import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Pet's gender in the pet shop helper.
 * Guarantees: Only two valid constants: FEMALE and MALE.
 */
public class Gender {

    public static final String MESSAGE_CONSTRAINTS = "Gender should be either male or female";

    private String value;

    /**
     * Constructs a {@code Name}.
     *
     * @param gender A valid gender.
     */
    public Gender(String gender) {
        checkArgument(isValidGender(gender), MESSAGE_CONSTRAINTS);
        this.value = gender;
    }

    public static boolean isValidGender(String test) {
        return (test.equals("male")) || (test.equals("female"));
    }

    @Override
    public String toString() {
        return value;
    }

}
