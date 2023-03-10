package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.domain.Hisse;
import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.domain.Mesaj;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.enumeration.KurbanKunye;
import com.aurora.ekurban.service.MesajService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class MesajStepDefinitions {

    Hissedar hissedar;
    Kurban kurban;

    Hisse hisse;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    MesajService mesajService;

    @Given("Hissedarın, halihazırda kurban seçip hissedar listesinde ismi olmalıdır")
    public void hissedarinHalihazirdaKurbanSecipHissedarListesindeIsmiOlmalidir() {
        hissedar = new Hissedar("Mehmet", "Ercan", "12345678L");

        kurban = new Kurban(KurbanCins.KUCUKBAS, KurbanKunye.KOYUN, "21A1", 428
                , 25, 53750, 1, "");
        hisse = new Hisse(kurban, hissedar);
    }

    @When("Hissedarların kurbanı kesildiğinde")
    public void hissedarlarinKurbaniKesildiginde() throws Exception {
        kurban.setDurum(KurbanDurum.KESILDI);
        Mesaj mesaj = mesajService.sendMesaj(KurbanDurum.KESILDI, hissedar, kurban);
        scenarioContext.setContext("kesildi", mesaj);
    }

    @Then("Hissedarlara kurban kesildi mesajı gönderilir")
    public void hissedarlaraKurbanKesildiMesajiGonderilir() {
        Mesaj result = (Mesaj) scenarioContext.getContext("kesildi");
        Assert.assertEquals(KurbanDurum.KESILDI, result.getTur());
    }
}
