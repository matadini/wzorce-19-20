package pl.sda.wzorce.behawioralne.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

interface Command {
    void execute();

    void undo();
}

@RequiredArgsConstructor
class ScoreUpCommand implements Command {

    private final AtomicInteger score;

    @Override
    public void execute() {
        score.incrementAndGet();
    }

    @Override
    public void undo() {
        score.decrementAndGet();
    }
}

// komenda wkleja do "edytora" tekst
@Data
@AllArgsConstructor
class TextEditor {
    String textEditorText;

    void print() {
        System.out.println(textEditorText);
    }
}

@RequiredArgsConstructor
class TextEditorCommand implements Command {
    private final TextEditor textEditorText;
    boolean executed = false;
    @Override
    public void execute() {
        if (!executed) {
            String schowek = "wklejony tekst";
            String newValue = textEditorText.getTextEditorText() + schowek;
            textEditorText.setTextEditorText(newValue);
            executed = true;
        }
    }

    @Override
    public void undo() {
        if(executed) {
            String newValue = textEditorText.getTextEditorText().replace("wklejony tekst", "");
            textEditorText.setTextEditorText(newValue);
            executed = false;
        }
    }
}

@RequiredArgsConstructor
class TextEditorCommandUppercase implements Command {

    private final TextEditor textEditorText;
    String cache;

    @Override
    public void execute() {
        cache = textEditorText.getTextEditorText();
        textEditorText.setTextEditorText(textEditorText.getTextEditorText().toUpperCase());
    }

    @Override
    public void undo() {
        textEditorText.setTextEditorText(cache);
    }
}

class CommandApp {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor(" jakis ZACZETY tekst.. ");
        // uzycie ctr+v
        TextEditorCommand textEditorCommand = new TextEditorCommand(editor);
        textEditorCommand.execute();
        editor.print();
        // uzycie ctr+z
        textEditorCommand.undo();
        editor.print();

        TextEditorCommandUppercase textEditorCommandUppercase = new TextEditorCommandUppercase(editor);
        textEditorCommandUppercase.execute();
        editor.print();
        textEditorCommandUppercase.undo();
        editor.print();

        List<Command> list = new ArrayList<>();
        list.add(textEditorCommand);
        list.add(textEditorCommand);
        list.add(textEditorCommand);
        list.add(new TextEditorCommandUppercase(editor));
        for(Command item : list) {
            item.execute();
            editor.print();
        }


//        AtomicInteger playerScore = new AtomicInteger(0); //Integer.valueOf(0);
//        new ScoreUpCommand(playerScore).execute();
//        new ScoreUpCommand(playerScore).execute();
//        ScoreUpCommand scoreUpCommand = new ScoreUpCommand(playerScore);
//        scoreUpCommand.execute();
//        System.out.println(playerScore.get());
//        scoreUpCommand.undo();
//        System.out.println(playerScore.get());
    }
}
