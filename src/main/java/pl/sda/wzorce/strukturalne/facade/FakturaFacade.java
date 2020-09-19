package pl.sda.wzorce.strukturalne.facade;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FakturaFacade {
    private final NotificationService notificationService;
    private final FakturaDb fakturaDb;
    private String eloszka;

    void save(String xml) {
        fakturaDb.save(xml);
    }

    void sendMail() {
        notificationService.execute();
    }
}
