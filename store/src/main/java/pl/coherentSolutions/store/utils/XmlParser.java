package pl.coherentSolutions.store.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pl.coherentSolutions.store.constant.XmlKey;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class XmlParser {

    private static final Properties xmlPath = PropertyUtil.getProperties("xmlPath.properties");

    public Map<String, String> getSortConfigFromXml() {
        Map<String, String> configMap = new LinkedHashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            String pathToConfigFile = xmlPath.getProperty("pathXml");
            Document document = builder.parse(pathToConfigFile);

            Node node = document.getElementsByTagName(XmlKey.TAG).item(XmlKey.INDEX_TAG);
            NodeList nodeList = node.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeList.item(i);
                    configMap.put(element.getTagName(), element.getTextContent());
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return configMap;
    }
}
