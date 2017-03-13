package algorithms;

import java.util.List;
import java.util.Map;

/**
 * Since XML is very verbose, you are given a way of encoding it where each tag gets
 * mapped to a pre-defined integer value.
 * For example, the following XML might be converted into the compressed string below (assuming a
 * mapping of family -> 1, person ->2, firstName -> 3, lastName -> 4, state
 * -> 5).
 * <family lastName="McDowell" state="CA">
 * <person firstName="Gayle">Some Message</person>
 * </family>
 * Becomes:
 * 1 4 McDowell SCA 0 2 3 Gayle 0 Some Message 0 0
 * <code>XmlEncoder</code> prints the encoded version of an XML element.
 */
public class XmlEncoder {
  Map<String, Integer> map;

  private XmlEncoder() {
  }

  public XmlEncoder(Map<String, Integer> map) {
    if (map == null) {
      throw new IllegalStateException("ERROR: Cannot instantiate XmlEncoder with empty map!");
    }
    this.map = map;
  }

  public String encode(XmlElement root) {
    return encodeElement(root, new StringBuilder());
  }

  private String encodeElement(XmlElement elem, StringBuilder enc) {
    enc.append(map.get(elem.name) + " ");
    encodeAttributes(elem.attrs, enc);
    enc.append("0 ");
    if (elem.children == null) {
      enc.append(elem.value);
    } else {
      for (XmlElement child : elem.children) {
        encodeElement(child, enc);
      }
    }
    enc.append("0 ");
    return enc.toString();
  }

  private void encodeAttributes(List<XmlAttribute> attrs, StringBuilder enc) {
    for (XmlAttribute attr : attrs) {
      enc.append(map.get(attr.name) + " ");
      enc.append(attr.value + " ");
    }
  }

  static class XmlElement {
    String name;
    String value;
    List<XmlAttribute> attrs;
    List<XmlElement> children;
  }

  static class XmlAttribute {
    String name;
    String value;
  }
}
