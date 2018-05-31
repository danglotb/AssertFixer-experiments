/*
 * mzTab validation API.
 * This is an mzTab validation service.
 *
 * OpenAPI spec version: 1.1.0
 * Contact: nils.hoffmann@isas.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package de.isas.mztab1_1.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.isas.mztab1_1.model.Comment;
import de.isas.mztab1_1.model.OptColumnMapping;
import de.isas.mztab1_1.model.Parameter;
import de.isas.mztab1_1.model.SpectraRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import javax.xml.bind.annotation.*;
import javax.validation.constraints.*;
import javax.validation.Valid;
import de.isas.lipidomics.jmztabm.validation.constraints.*;
/**
 * SmallMoleculeEvidence
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-31T17:58:50.083+02:00")
@XmlRootElement(name = "SmallMoleculeEvidence")
@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "SmallMoleculeEvidence")
public class SmallMoleculeEvidence {

  public static enum Properties {
      prefix("prefix"), 
      headerPrefix("header_prefix"), 
      smeId("sme_id"), 
      evidenceInputId("evidence_input_id"), 
      databaseIdentifier("database_identifier"), 
      chemicalFormula("chemical_formula"), 
      smiles("smiles"), 
      inchi("inchi"), 
      chemicalName("chemical_name"), 
      uri("uri"), 
      derivatizedForm("derivatized_form"), 
      adductIon("adduct_ion"), 
      expMassToCharge("exp_mass_to_charge"), 
      charge("charge"), 
      theoreticalMassToCharge("theoretical_mass_to_charge"), 
      spectraRef("spectra_ref"), 
      identificationMethod("identification_method"), 
      msLevel("ms_level"), 
      idConfidenceMeasure("id_confidence_measure"), 
      rank("rank"), 
      opt("opt"), 
      comment("comment");

    private final String propertyName;

    private Properties(String propertyName) {
      this.propertyName = propertyName;
    }

    public String getPropertyName() {
      return propertyName;
    }

    public String toString() {
      return propertyName;
    }

    public String toUpper() {
      return propertyName.toUpperCase();
    }

    public static Properties of(String value) {
      if(value==null) {
        throw new NullPointerException("Argument value must not be null!");
      }
      return Arrays.asList(Properties.values()).stream().filter(m -> m.propertyName.equals(value.toLowerCase())).findAny().orElseThrow(IllegalArgumentException::new);
    }
  };
  
  /**
   * Gets or Sets prefix
   */
  public enum PrefixEnum {
    SME("SME");

    private String value;

    PrefixEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PrefixEnum fromValue(String text) {
      for (PrefixEnum b : PrefixEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("prefix")
  @JacksonXmlProperty(localName = "prefix")
  @XmlElement(name = "prefix")
  private PrefixEnum prefix = PrefixEnum.SME;
  /**
   * Gets or Sets headerPrefix
   */
  public enum HeaderPrefixEnum {
    SEH("SEH");

    private String value;

    HeaderPrefixEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static HeaderPrefixEnum fromValue(String text) {
      for (HeaderPrefixEnum b : HeaderPrefixEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("header_prefix")
  @JacksonXmlProperty(localName = "header_prefix")
  @XmlElement(name = "header_prefix")
  private HeaderPrefixEnum headerPrefix = HeaderPrefixEnum.SEH;
  @JsonProperty("sme_id")
  @JacksonXmlProperty(localName = "sme_id")
  @XmlElement(name = "sme_id")
  private String smeId = null;
  @JsonProperty("evidence_input_id")
  @JacksonXmlProperty(localName = "evidence_input_id")
  @XmlElement(name = "evidence_input_id")
  private String evidenceInputId = null;
  @JsonProperty("database_identifier")
  @JacksonXmlProperty(localName = "database_identifier")
  @XmlElement(name = "database_identifier")
  private String databaseIdentifier = null;
  @JsonProperty("chemical_formula")
  @JacksonXmlProperty(localName = "chemical_formula")
  @XmlElement(name = "chemical_formula")
  private String chemicalFormula = null;
  @JsonProperty("smiles")
  @JacksonXmlProperty(localName = "smiles")
  @XmlElement(name = "smiles")
  private String smiles = null;
  @JsonProperty("inchi")
  @JacksonXmlProperty(localName = "inchi")
  @XmlElement(name = "inchi")
  private String inchi = null;
  @JsonProperty("chemical_name")
  @JacksonXmlProperty(localName = "chemical_name")
  @XmlElement(name = "chemical_name")
  private String chemicalName = null;
  @JsonProperty("uri")
  @JacksonXmlProperty(localName = "uri")
  @XmlElement(name = "uri")
  private String uri = null;
  @JsonProperty("derivatized_form")
  @JacksonXmlProperty(localName = "derivatized_form")
  @XmlElement(name = "derivatized_form")
  private Parameter derivatizedForm = null;
  @JsonProperty("adduct_ion")
  @JacksonXmlProperty(localName = "adduct_ion")
  @XmlElement(name = "adduct_ion")
  private String adductIon = null;
  @JsonProperty("exp_mass_to_charge")
  @JacksonXmlProperty(localName = "exp_mass_to_charge")
  @XmlElement(name = "exp_mass_to_charge")
  private Double expMassToCharge = null;
  @JsonProperty("charge")
  @JacksonXmlProperty(localName = "charge")
  @XmlElement(name = "charge")
  private Integer charge = null;
  @JsonProperty("theoretical_mass_to_charge")
  @JacksonXmlProperty(localName = "theoretical_mass_to_charge")
  @XmlElement(name = "theoretical_mass_to_charge")
  private Double theoreticalMassToCharge = null;
  @JsonProperty("spectra_ref")
  // Is a container wrapped=false
  // items.name=spectraRef items.baseName=spectraRef items.xmlName= items.xmlNamespace=
  // items.example= items.type=SpectraRef
  @XmlElement(name = "spectraRef")
  private List<SpectraRef> spectraRef = null;
  @JsonProperty("identification_method")
  @JacksonXmlProperty(localName = "identification_method")
  @XmlElement(name = "identification_method")
  private Parameter identificationMethod = null;
  @JsonProperty("ms_level")
  @JacksonXmlProperty(localName = "ms_level")
  @XmlElement(name = "ms_level")
  private Parameter msLevel = null;
  @JsonProperty("id_confidence_measure")
  // Is a container wrapped=false
  // items.name=idConfidenceMeasure items.baseName=idConfidenceMeasure items.xmlName= items.xmlNamespace=
  // items.example= items.type=Double
  @XmlElement(name = "idConfidenceMeasure")
  private List<Double> idConfidenceMeasure = null;
  @JsonProperty("rank")
  @JacksonXmlProperty(localName = "rank")
  @XmlElement(name = "rank")
  private Integer rank = null;
  @JsonProperty("opt")
  // Is a container wrapped=false
  // items.name=opt items.baseName=opt items.xmlName= items.xmlNamespace=
  // items.example= items.type=OptColumnMapping
  @XmlElement(name = "opt")
  private List<OptColumnMapping> opt = null;
  @JsonProperty("comment")
  // Is a container wrapped=false
  // items.name=comment items.baseName=comment items.xmlName= items.xmlNamespace=
  // items.example= items.type=Comment
  @XmlElement(name = "comment")
  private List<Comment> comment = null;
   /**
   * Get prefix
   * @return prefix
  **/
  @NotNull
  @ApiModelProperty(required = true, value = "")
  public PrefixEnum getPrefix() {
    return prefix;
  }

   /**
   * Get headerPrefix
   * @return headerPrefix
  **/
  @NotNull
  @ApiModelProperty(required = true, value = "")
  public HeaderPrefixEnum getHeaderPrefix() {
    return headerPrefix;
  }


  public SmallMoleculeEvidence smeId(String smeId) {
   this.smeId = smeId;
   return this;
  }

   /**
   * Get smeId
   * @return smeId
  **/
  @ApiModelProperty(value = "")
  public String getSmeId() {
    return smeId;
  }

  public void setSmeId(String smeId) {
    this.smeId = smeId;
  }


  public SmallMoleculeEvidence evidenceInputId(String evidenceInputId) {
   this.evidenceInputId = evidenceInputId;
   return this;
  }

   /**
   * Get evidenceInputId
   * @return evidenceInputId
  **/
  @ApiModelProperty(value = "")
  public String getEvidenceInputId() {
    return evidenceInputId;
  }

  public void setEvidenceInputId(String evidenceInputId) {
    this.evidenceInputId = evidenceInputId;
  }


  public SmallMoleculeEvidence databaseIdentifier(String databaseIdentifier) {
   this.databaseIdentifier = databaseIdentifier;
   return this;
  }

   /**
   * Get databaseIdentifier
   * @return databaseIdentifier
  **/
  @ApiModelProperty(value = "")
  public String getDatabaseIdentifier() {
    return databaseIdentifier;
  }

  public void setDatabaseIdentifier(String databaseIdentifier) {
    this.databaseIdentifier = databaseIdentifier;
  }


  public SmallMoleculeEvidence chemicalFormula(String chemicalFormula) {
   this.chemicalFormula = chemicalFormula;
   return this;
  }

   /**
   * Get chemicalFormula
   * @return chemicalFormula
  **/
  @ApiModelProperty(value = "")
  public String getChemicalFormula() {
    return chemicalFormula;
  }

  public void setChemicalFormula(String chemicalFormula) {
    this.chemicalFormula = chemicalFormula;
  }


  public SmallMoleculeEvidence smiles(String smiles) {
   this.smiles = smiles;
   return this;
  }

   /**
   * Get smiles
   * @return smiles
  **/
  @ApiModelProperty(value = "")
  public String getSmiles() {
    return smiles;
  }

  public void setSmiles(String smiles) {
    this.smiles = smiles;
  }


  public SmallMoleculeEvidence inchi(String inchi) {
   this.inchi = inchi;
   return this;
  }

   /**
   * Get inchi
   * @return inchi
  **/
  @ApiModelProperty(value = "")
  public String getInchi() {
    return inchi;
  }

  public void setInchi(String inchi) {
    this.inchi = inchi;
  }


  public SmallMoleculeEvidence chemicalName(String chemicalName) {
   this.chemicalName = chemicalName;
   return this;
  }

   /**
   * Get chemicalName
   * @return chemicalName
  **/
  @ApiModelProperty(value = "")
  public String getChemicalName() {
    return chemicalName;
  }

  public void setChemicalName(String chemicalName) {
    this.chemicalName = chemicalName;
  }


  public SmallMoleculeEvidence uri(String uri) {
   this.uri = uri;
   return this;
  }

   /**
   * Get uri
   * @return uri
  **/
  @ApiModelProperty(value = "")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  public SmallMoleculeEvidence derivatizedForm(Parameter derivatizedForm) {
   this.derivatizedForm = derivatizedForm;
   return this;
  }

   /**
   * Get derivatizedForm
   * @return derivatizedForm
  **/
  @Valid
  @ApiModelProperty(value = "")
  public Parameter getDerivatizedForm() {
    return derivatizedForm;
  }

  public void setDerivatizedForm(Parameter derivatizedForm) {
    this.derivatizedForm = derivatizedForm;
  }


  public SmallMoleculeEvidence adductIon(String adductIon) {
   this.adductIon = adductIon;
   return this;
  }

   /**
   * Get adductIon
   * @return adductIon
  **/
 @Pattern(regexp="^\\[\\d*M([-][\\w]*)\\]\\d*[+-]$")  @ApiModelProperty(value = "")
  public String getAdductIon() {
    return adductIon;
  }

  public void setAdductIon(String adductIon) {
    this.adductIon = adductIon;
  }


  public SmallMoleculeEvidence expMassToCharge(Double expMassToCharge) {
   this.expMassToCharge = expMassToCharge;
   return this;
  }

   /**
   * Get expMassToCharge
   * @return expMassToCharge
  **/
  @ApiModelProperty(value = "")
  public Double getExpMassToCharge() {
    return expMassToCharge;
  }

  public void setExpMassToCharge(Double expMassToCharge) {
    this.expMassToCharge = expMassToCharge;
  }


  public SmallMoleculeEvidence charge(Integer charge) {
   this.charge = charge;
   return this;
  }

   /**
   * Get charge
   * @return charge
  **/
  @ApiModelProperty(value = "")
  public Integer getCharge() {
    return charge;
  }

  public void setCharge(Integer charge) {
    this.charge = charge;
  }


  public SmallMoleculeEvidence theoreticalMassToCharge(Double theoreticalMassToCharge) {
   this.theoreticalMassToCharge = theoreticalMassToCharge;
   return this;
  }

   /**
   * Get theoreticalMassToCharge
   * @return theoreticalMassToCharge
  **/
  @ApiModelProperty(value = "")
  public Double getTheoreticalMassToCharge() {
    return theoreticalMassToCharge;
  }

  public void setTheoreticalMassToCharge(Double theoreticalMassToCharge) {
    this.theoreticalMassToCharge = theoreticalMassToCharge;
  }


  public SmallMoleculeEvidence spectraRef(List<SpectraRef> spectraRef) {
   this.spectraRef = spectraRef;
   return this;
  }

  public SmallMoleculeEvidence addSpectraRefItem(SpectraRef spectraRefItem) {
    if (this.spectraRef == null) {
      this.spectraRef = new ArrayList<>();
    }
    this.spectraRef.add(spectraRefItem);
    return this;
  }

   /**
   * Get spectraRef
   * @return spectraRef
  **/
  @Valid
  @ApiModelProperty(value = "")
  public List<SpectraRef> getSpectraRef() {
    return spectraRef;
  }

  public void setSpectraRef(List<SpectraRef> spectraRef) {
    this.spectraRef = spectraRef;
  }


  public SmallMoleculeEvidence identificationMethod(Parameter identificationMethod) {
   this.identificationMethod = identificationMethod;
   return this;
  }

   /**
   * Get identificationMethod
   * @return identificationMethod
  **/
  @Valid
  @ApiModelProperty(value = "")
  public Parameter getIdentificationMethod() {
    return identificationMethod;
  }

  public void setIdentificationMethod(Parameter identificationMethod) {
    this.identificationMethod = identificationMethod;
  }


  public SmallMoleculeEvidence msLevel(Parameter msLevel) {
   this.msLevel = msLevel;
   return this;
  }

   /**
   * Get msLevel
   * @return msLevel
  **/
  @Valid
  @ApiModelProperty(value = "")
  public Parameter getMsLevel() {
    return msLevel;
  }

  public void setMsLevel(Parameter msLevel) {
    this.msLevel = msLevel;
  }


  public SmallMoleculeEvidence idConfidenceMeasure(List<Double> idConfidenceMeasure) {
   this.idConfidenceMeasure = idConfidenceMeasure;
   return this;
  }

  public SmallMoleculeEvidence addIdConfidenceMeasureItem(Double idConfidenceMeasureItem) {
    if (this.idConfidenceMeasure == null) {
      this.idConfidenceMeasure = new ArrayList<>();
    }
    this.idConfidenceMeasure.add(idConfidenceMeasureItem);
    return this;
  }

   /**
   * Get idConfidenceMeasure
   * @return idConfidenceMeasure
  **/
  @ApiModelProperty(value = "")
  public List<Double> getIdConfidenceMeasure() {
    return idConfidenceMeasure;
  }

  public void setIdConfidenceMeasure(List<Double> idConfidenceMeasure) {
    this.idConfidenceMeasure = idConfidenceMeasure;
  }


  public SmallMoleculeEvidence rank(Integer rank) {
   this.rank = rank;
   return this;
  }

   /**
   * Get rank
   * @return rank
  **/
  @ApiModelProperty(value = "")
  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }


  public SmallMoleculeEvidence opt(List<OptColumnMapping> opt) {
   this.opt = opt;
   return this;
  }

  public SmallMoleculeEvidence addOptItem(OptColumnMapping optItem) {
    if (this.opt == null) {
      this.opt = new ArrayList<>();
    }
    this.opt.add(optItem);
    return this;
  }

   /**
   * Get opt
   * @return opt
  **/
  @Valid
  @ApiModelProperty(value = "")
  public List<OptColumnMapping> getOpt() {
    return opt;
  }

  public void setOpt(List<OptColumnMapping> opt) {
    this.opt = opt;
  }


  public SmallMoleculeEvidence comment(List<Comment> comment) {
   this.comment = comment;
   return this;
  }

  public SmallMoleculeEvidence addCommentItem(Comment commentItem) {
    if (this.comment == null) {
      this.comment = new ArrayList<>();
    }
    this.comment.add(commentItem);
    return this;
  }

   /**
   * Get comment
   * @return comment
  **/
  @Valid
  @ApiModelProperty(value = "")
  public List<Comment> getComment() {
    return comment;
  }

  public void setComment(List<Comment> comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmallMoleculeEvidence smallMoleculeEvidence = (SmallMoleculeEvidence) o;
    return Objects.equals(this.prefix, smallMoleculeEvidence.prefix) &&
        Objects.equals(this.headerPrefix, smallMoleculeEvidence.headerPrefix) &&
        Objects.equals(this.smeId, smallMoleculeEvidence.smeId) &&
        Objects.equals(this.evidenceInputId, smallMoleculeEvidence.evidenceInputId) &&
        Objects.equals(this.databaseIdentifier, smallMoleculeEvidence.databaseIdentifier) &&
        Objects.equals(this.chemicalFormula, smallMoleculeEvidence.chemicalFormula) &&
        Objects.equals(this.smiles, smallMoleculeEvidence.smiles) &&
        Objects.equals(this.inchi, smallMoleculeEvidence.inchi) &&
        Objects.equals(this.chemicalName, smallMoleculeEvidence.chemicalName) &&
        Objects.equals(this.uri, smallMoleculeEvidence.uri) &&
        Objects.equals(this.derivatizedForm, smallMoleculeEvidence.derivatizedForm) &&
        Objects.equals(this.adductIon, smallMoleculeEvidence.adductIon) &&
        Objects.equals(this.expMassToCharge, smallMoleculeEvidence.expMassToCharge) &&
        Objects.equals(this.charge, smallMoleculeEvidence.charge) &&
        Objects.equals(this.theoreticalMassToCharge, smallMoleculeEvidence.theoreticalMassToCharge) &&
        Objects.equals(this.spectraRef, smallMoleculeEvidence.spectraRef) &&
        Objects.equals(this.identificationMethod, smallMoleculeEvidence.identificationMethod) &&
        Objects.equals(this.msLevel, smallMoleculeEvidence.msLevel) &&
        Objects.equals(this.idConfidenceMeasure, smallMoleculeEvidence.idConfidenceMeasure) &&
        Objects.equals(this.rank, smallMoleculeEvidence.rank) &&
        Objects.equals(this.opt, smallMoleculeEvidence.opt) &&
        Objects.equals(this.comment, smallMoleculeEvidence.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prefix, headerPrefix, smeId, evidenceInputId, databaseIdentifier, chemicalFormula, smiles, inchi, chemicalName, uri, derivatizedForm, adductIon, expMassToCharge, charge, theoreticalMassToCharge, spectraRef, identificationMethod, msLevel, idConfidenceMeasure, rank, opt, comment);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmallMoleculeEvidence {\n");
    
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    headerPrefix: ").append(toIndentedString(headerPrefix)).append("\n");
    sb.append("    smeId: ").append(toIndentedString(smeId)).append("\n");
    sb.append("    evidenceInputId: ").append(toIndentedString(evidenceInputId)).append("\n");
    sb.append("    databaseIdentifier: ").append(toIndentedString(databaseIdentifier)).append("\n");
    sb.append("    chemicalFormula: ").append(toIndentedString(chemicalFormula)).append("\n");
    sb.append("    smiles: ").append(toIndentedString(smiles)).append("\n");
    sb.append("    inchi: ").append(toIndentedString(inchi)).append("\n");
    sb.append("    chemicalName: ").append(toIndentedString(chemicalName)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    derivatizedForm: ").append(toIndentedString(derivatizedForm)).append("\n");
    sb.append("    adductIon: ").append(toIndentedString(adductIon)).append("\n");
    sb.append("    expMassToCharge: ").append(toIndentedString(expMassToCharge)).append("\n");
    sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
    sb.append("    theoreticalMassToCharge: ").append(toIndentedString(theoreticalMassToCharge)).append("\n");
    sb.append("    spectraRef: ").append(toIndentedString(spectraRef)).append("\n");
    sb.append("    identificationMethod: ").append(toIndentedString(identificationMethod)).append("\n");
    sb.append("    msLevel: ").append(toIndentedString(msLevel)).append("\n");
    sb.append("    idConfidenceMeasure: ").append(toIndentedString(idConfidenceMeasure)).append("\n");
    sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
    sb.append("    opt: ").append(toIndentedString(opt)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

