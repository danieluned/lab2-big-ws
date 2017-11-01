package translator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TranslatorServiceTest.class);
	
    @Autowired
    TranslatorService translatorService;
    @Test
    public void translateTest() throws Exception {
        TranslatedText translatedText = translatorService.translate("en", "es", "This is a test of translation service");
        assertEquals("Esto es una prueba de servicio de traducción",translatedText.getTranslation());
    }

    @Test
    public void translateTestEsRu() throws Exception {
        TranslatedText translatedText = translatorService.translate("es", "ru", "La descarga ya esta disponible.");
        LOGGER.debug("Traducción ES: \"La descarga ya esta disponible\" RU: "+translatedText.getTranslation());    
        assertEquals("Скачивание уже доступно.",translatedText.getTranslation());
    }
}
