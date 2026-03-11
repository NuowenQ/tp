package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String HELP_MESSAGE = "InternTracker – Command Help\n\n"
            + "Track your internship applications using the commands below.\n\n"
            + "add: Add a new application.\n"
            + "  Format: add n/COMPANY r/ROLE s/STATUS d/DATE [j/DESCRIPTION] [e/EMAIL] [w/WEBSITE]\n"
            + "  Status must be Pending, Rejected, or Offered. Date must be YYYY-MM-DD.\n"
            + "  Example: add n/Google r/Software Engineer s/Pending d/2026-02-19 e/hr@google.com\n\n"
            + "list: Display all saved applications.\n\n"
            + "edit: Update an application by its list number.\n"
            + "  Format: edit INDEX [n/COMPANY] [r/ROLE] [s/STATUS] [d/DATE] "
            + "[j/DESCRIPTION] [e/EMAIL] [w/WEBSITE]\n"
            + "  At least one field must be provided.\n"
            + "  Example: edit 1 s/Offered\n\n"
            + "delete: Remove an application by its list number.\n"
            + "  Format: delete INDEX\n"
            + "  Example: delete 3\n\n"
            + "help: Show this help message.";

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private TextFlow helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.getChildren().setAll(new Text(HELP_MESSAGE));
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }
}
