package pl.sda.wzorce.strukturalne.proxy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TerminatorProxy implements Terminator {
    private final String user;
    private final Terminator terminator;

    @Override
    public void shot() {
        if (user.equals("janek")) {
            terminator.shot();
        } else {
            System.out.println("nie mozesz sie bawic");
        }
    }

    @Override
    public void fight() {
        if (user.equals("janek")) {
            terminator.fight();
        } else {
            System.out.println("nie mozesz walczyc");
        }
    }
}
