package seedu.address.logic.commands.slot;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.PshModel;
import seedu.address.model.pet.NameContainsKeywordsPredicate;

/**
 * Finds and lists all slots in the schedule whose contents contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindSlotCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all slots whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " garfield 10/11/2020";

    private final NameContainsKeywordsPredicate predicate;

    public FindSlotCommand(NameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(PshModel model) {
        requireNonNull(model);
        model.updateFilteredSlotList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_SLOTS_LISTED_OVERVIEW, model.getFilteredSlotList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindSlotCommand // instanceof handles nulls
                && predicate.equals(((FindSlotCommand) other).predicate)); // state check
    }
}
