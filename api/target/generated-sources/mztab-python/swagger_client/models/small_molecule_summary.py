# coding: utf-8

"""
    mzTab validation API.

    This is an mzTab validation service.  # noqa: E501

    OpenAPI spec version: 1.1.0
    Contact: nils.hoffmann@isas.de
    Generated by: https://github.com/swagger-api/swagger-codegen.git
"""


import pprint
import re  # noqa: F401

import six

from swagger_client.models.comment import Comment  # noqa: F401,E501
from swagger_client.models.opt_column_mapping import OptColumnMapping  # noqa: F401,E501
from swagger_client.models.parameter import Parameter  # noqa: F401,E501


class SmallMoleculeSummary(object):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """

    """
    Attributes:
      swagger_types (dict): The key is attribute name
                            and the value is attribute type.
      attribute_map (dict): The key is attribute name
                            and the value is json key in definition.
    """
    swagger_types = {
        'prefix': 'str',
        'header_prefix': 'str',
        'sml_id': 'str',
        'smf_id_refs': 'list[str]',
        'database_identifier': 'list[str]',
        'chemical_formula': 'list[str]',
        'smiles': 'list[str]',
        'inchi': 'list[str]',
        'chemical_name': 'list[str]',
        'uri': 'list[str]',
        'theoretical_neutral_mass': 'list[float]',
        'adduct_ions': 'list[str]',
        'reliability': 'str',
        'best_id_confidence_measure': 'Parameter',
        'best_id_confidence_value': 'float',
        'abundance_assay': 'list[float]',
        'abundance_study_variable': 'list[float]',
        'abundance_variation_study_variable': 'list[float]',
        'opt': 'list[OptColumnMapping]',
        'comment': 'list[Comment]'
    }

    attribute_map = {
        'prefix': 'prefix',
        'header_prefix': 'header_prefix',
        'sml_id': 'sml_id',
        'smf_id_refs': 'smf_id_refs',
        'database_identifier': 'database_identifier',
        'chemical_formula': 'chemical_formula',
        'smiles': 'smiles',
        'inchi': 'inchi',
        'chemical_name': 'chemical_name',
        'uri': 'uri',
        'theoretical_neutral_mass': 'theoretical_neutral_mass',
        'adduct_ions': 'adduct_ions',
        'reliability': 'reliability',
        'best_id_confidence_measure': 'best_id_confidence_measure',
        'best_id_confidence_value': 'best_id_confidence_value',
        'abundance_assay': 'abundance_assay',
        'abundance_study_variable': 'abundance_study_variable',
        'abundance_variation_study_variable': 'abundance_variation_study_variable',
        'opt': 'opt',
        'comment': 'comment'
    }

    def __init__(self, prefix='SML', header_prefix='SMH', sml_id=None, smf_id_refs=None, database_identifier=None, chemical_formula=None, smiles=None, inchi=None, chemical_name=None, uri=None, theoretical_neutral_mass=None, adduct_ions=None, reliability=None, best_id_confidence_measure=None, best_id_confidence_value=None, abundance_assay=None, abundance_study_variable=None, abundance_variation_study_variable=None, opt=None, comment=None):  # noqa: E501
        """SmallMoleculeSummary - a model defined in Swagger"""  # noqa: E501

        self._prefix = None
        self._header_prefix = None
        self._sml_id = None
        self._smf_id_refs = None
        self._database_identifier = None
        self._chemical_formula = None
        self._smiles = None
        self._inchi = None
        self._chemical_name = None
        self._uri = None
        self._theoretical_neutral_mass = None
        self._adduct_ions = None
        self._reliability = None
        self._best_id_confidence_measure = None
        self._best_id_confidence_value = None
        self._abundance_assay = None
        self._abundance_study_variable = None
        self._abundance_variation_study_variable = None
        self._opt = None
        self._comment = None
        self.discriminator = None

        self.prefix = prefix
        self.header_prefix = header_prefix
        self.sml_id = sml_id
        self.smf_id_refs = smf_id_refs
        if database_identifier is not None:
            self.database_identifier = database_identifier
        if chemical_formula is not None:
            self.chemical_formula = chemical_formula
        if smiles is not None:
            self.smiles = smiles
        if inchi is not None:
            self.inchi = inchi
        if chemical_name is not None:
            self.chemical_name = chemical_name
        if uri is not None:
            self.uri = uri
        if theoretical_neutral_mass is not None:
            self.theoretical_neutral_mass = theoretical_neutral_mass
        if adduct_ions is not None:
            self.adduct_ions = adduct_ions
        if reliability is not None:
            self.reliability = reliability
        if best_id_confidence_measure is not None:
            self.best_id_confidence_measure = best_id_confidence_measure
        if best_id_confidence_value is not None:
            self.best_id_confidence_value = best_id_confidence_value
        if abundance_assay is not None:
            self.abundance_assay = abundance_assay
        if abundance_study_variable is not None:
            self.abundance_study_variable = abundance_study_variable
        if abundance_variation_study_variable is not None:
            self.abundance_variation_study_variable = abundance_variation_study_variable
        if opt is not None:
            self.opt = opt
        if comment is not None:
            self.comment = comment

    @property
    def prefix(self):
        """Gets the prefix of this SmallMoleculeSummary.  # noqa: E501


        :return: The prefix of this SmallMoleculeSummary.  # noqa: E501
        :rtype: str
        """
        return self._prefix

    @prefix.setter
    def prefix(self, prefix):
        """Sets the prefix of this SmallMoleculeSummary.


        :param prefix: The prefix of this SmallMoleculeSummary.  # noqa: E501
        :type: str
        """
        if prefix is None:
            raise ValueError("Invalid value for `prefix`, must not be `None`")  # noqa: E501
        allowed_values = ["SML"]  # noqa: E501
        if prefix not in allowed_values:
            raise ValueError(
                "Invalid value for `prefix` ({0}), must be one of {1}"  # noqa: E501
                .format(prefix, allowed_values)
            )

        self._prefix = prefix

    @property
    def header_prefix(self):
        """Gets the header_prefix of this SmallMoleculeSummary.  # noqa: E501


        :return: The header_prefix of this SmallMoleculeSummary.  # noqa: E501
        :rtype: str
        """
        return self._header_prefix

    @header_prefix.setter
    def header_prefix(self, header_prefix):
        """Sets the header_prefix of this SmallMoleculeSummary.


        :param header_prefix: The header_prefix of this SmallMoleculeSummary.  # noqa: E501
        :type: str
        """
        if header_prefix is None:
            raise ValueError("Invalid value for `header_prefix`, must not be `None`")  # noqa: E501
        allowed_values = ["SMH"]  # noqa: E501
        if header_prefix not in allowed_values:
            raise ValueError(
                "Invalid value for `header_prefix` ({0}), must be one of {1}"  # noqa: E501
                .format(header_prefix, allowed_values)
            )

        self._header_prefix = header_prefix

    @property
    def sml_id(self):
        """Gets the sml_id of this SmallMoleculeSummary.  # noqa: E501


        :return: The sml_id of this SmallMoleculeSummary.  # noqa: E501
        :rtype: str
        """
        return self._sml_id

    @sml_id.setter
    def sml_id(self, sml_id):
        """Sets the sml_id of this SmallMoleculeSummary.


        :param sml_id: The sml_id of this SmallMoleculeSummary.  # noqa: E501
        :type: str
        """
        if sml_id is None:
            raise ValueError("Invalid value for `sml_id`, must not be `None`")  # noqa: E501

        self._sml_id = sml_id

    @property
    def smf_id_refs(self):
        """Gets the smf_id_refs of this SmallMoleculeSummary.  # noqa: E501


        :return: The smf_id_refs of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[str]
        """
        return self._smf_id_refs

    @smf_id_refs.setter
    def smf_id_refs(self, smf_id_refs):
        """Sets the smf_id_refs of this SmallMoleculeSummary.


        :param smf_id_refs: The smf_id_refs of this SmallMoleculeSummary.  # noqa: E501
        :type: list[str]
        """
        if smf_id_refs is None:
            raise ValueError("Invalid value for `smf_id_refs`, must not be `None`")  # noqa: E501

        self._smf_id_refs = smf_id_refs

    @property
    def database_identifier(self):
        """Gets the database_identifier of this SmallMoleculeSummary.  # noqa: E501


        :return: The database_identifier of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[str]
        """
        return self._database_identifier

    @database_identifier.setter
    def database_identifier(self, database_identifier):
        """Sets the database_identifier of this SmallMoleculeSummary.


        :param database_identifier: The database_identifier of this SmallMoleculeSummary.  # noqa: E501
        :type: list[str]
        """

        self._database_identifier = database_identifier

    @property
    def chemical_formula(self):
        """Gets the chemical_formula of this SmallMoleculeSummary.  # noqa: E501


        :return: The chemical_formula of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[str]
        """
        return self._chemical_formula

    @chemical_formula.setter
    def chemical_formula(self, chemical_formula):
        """Sets the chemical_formula of this SmallMoleculeSummary.


        :param chemical_formula: The chemical_formula of this SmallMoleculeSummary.  # noqa: E501
        :type: list[str]
        """

        self._chemical_formula = chemical_formula

    @property
    def smiles(self):
        """Gets the smiles of this SmallMoleculeSummary.  # noqa: E501


        :return: The smiles of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[str]
        """
        return self._smiles

    @smiles.setter
    def smiles(self, smiles):
        """Sets the smiles of this SmallMoleculeSummary.


        :param smiles: The smiles of this SmallMoleculeSummary.  # noqa: E501
        :type: list[str]
        """

        self._smiles = smiles

    @property
    def inchi(self):
        """Gets the inchi of this SmallMoleculeSummary.  # noqa: E501


        :return: The inchi of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[str]
        """
        return self._inchi

    @inchi.setter
    def inchi(self, inchi):
        """Sets the inchi of this SmallMoleculeSummary.


        :param inchi: The inchi of this SmallMoleculeSummary.  # noqa: E501
        :type: list[str]
        """

        self._inchi = inchi

    @property
    def chemical_name(self):
        """Gets the chemical_name of this SmallMoleculeSummary.  # noqa: E501


        :return: The chemical_name of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[str]
        """
        return self._chemical_name

    @chemical_name.setter
    def chemical_name(self, chemical_name):
        """Sets the chemical_name of this SmallMoleculeSummary.


        :param chemical_name: The chemical_name of this SmallMoleculeSummary.  # noqa: E501
        :type: list[str]
        """

        self._chemical_name = chemical_name

    @property
    def uri(self):
        """Gets the uri of this SmallMoleculeSummary.  # noqa: E501


        :return: The uri of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[str]
        """
        return self._uri

    @uri.setter
    def uri(self, uri):
        """Sets the uri of this SmallMoleculeSummary.


        :param uri: The uri of this SmallMoleculeSummary.  # noqa: E501
        :type: list[str]
        """

        self._uri = uri

    @property
    def theoretical_neutral_mass(self):
        """Gets the theoretical_neutral_mass of this SmallMoleculeSummary.  # noqa: E501


        :return: The theoretical_neutral_mass of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[float]
        """
        return self._theoretical_neutral_mass

    @theoretical_neutral_mass.setter
    def theoretical_neutral_mass(self, theoretical_neutral_mass):
        """Sets the theoretical_neutral_mass of this SmallMoleculeSummary.


        :param theoretical_neutral_mass: The theoretical_neutral_mass of this SmallMoleculeSummary.  # noqa: E501
        :type: list[float]
        """

        self._theoretical_neutral_mass = theoretical_neutral_mass

    @property
    def adduct_ions(self):
        """Gets the adduct_ions of this SmallMoleculeSummary.  # noqa: E501


        :return: The adduct_ions of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[str]
        """
        return self._adduct_ions

    @adduct_ions.setter
    def adduct_ions(self, adduct_ions):
        """Sets the adduct_ions of this SmallMoleculeSummary.


        :param adduct_ions: The adduct_ions of this SmallMoleculeSummary.  # noqa: E501
        :type: list[str]
        """

        self._adduct_ions = adduct_ions

    @property
    def reliability(self):
        """Gets the reliability of this SmallMoleculeSummary.  # noqa: E501


        :return: The reliability of this SmallMoleculeSummary.  # noqa: E501
        :rtype: str
        """
        return self._reliability

    @reliability.setter
    def reliability(self, reliability):
        """Sets the reliability of this SmallMoleculeSummary.


        :param reliability: The reliability of this SmallMoleculeSummary.  # noqa: E501
        :type: str
        """

        self._reliability = reliability

    @property
    def best_id_confidence_measure(self):
        """Gets the best_id_confidence_measure of this SmallMoleculeSummary.  # noqa: E501


        :return: The best_id_confidence_measure of this SmallMoleculeSummary.  # noqa: E501
        :rtype: Parameter
        """
        return self._best_id_confidence_measure

    @best_id_confidence_measure.setter
    def best_id_confidence_measure(self, best_id_confidence_measure):
        """Sets the best_id_confidence_measure of this SmallMoleculeSummary.


        :param best_id_confidence_measure: The best_id_confidence_measure of this SmallMoleculeSummary.  # noqa: E501
        :type: Parameter
        """

        self._best_id_confidence_measure = best_id_confidence_measure

    @property
    def best_id_confidence_value(self):
        """Gets the best_id_confidence_value of this SmallMoleculeSummary.  # noqa: E501


        :return: The best_id_confidence_value of this SmallMoleculeSummary.  # noqa: E501
        :rtype: float
        """
        return self._best_id_confidence_value

    @best_id_confidence_value.setter
    def best_id_confidence_value(self, best_id_confidence_value):
        """Sets the best_id_confidence_value of this SmallMoleculeSummary.


        :param best_id_confidence_value: The best_id_confidence_value of this SmallMoleculeSummary.  # noqa: E501
        :type: float
        """

        self._best_id_confidence_value = best_id_confidence_value

    @property
    def abundance_assay(self):
        """Gets the abundance_assay of this SmallMoleculeSummary.  # noqa: E501


        :return: The abundance_assay of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[float]
        """
        return self._abundance_assay

    @abundance_assay.setter
    def abundance_assay(self, abundance_assay):
        """Sets the abundance_assay of this SmallMoleculeSummary.


        :param abundance_assay: The abundance_assay of this SmallMoleculeSummary.  # noqa: E501
        :type: list[float]
        """

        self._abundance_assay = abundance_assay

    @property
    def abundance_study_variable(self):
        """Gets the abundance_study_variable of this SmallMoleculeSummary.  # noqa: E501


        :return: The abundance_study_variable of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[float]
        """
        return self._abundance_study_variable

    @abundance_study_variable.setter
    def abundance_study_variable(self, abundance_study_variable):
        """Sets the abundance_study_variable of this SmallMoleculeSummary.


        :param abundance_study_variable: The abundance_study_variable of this SmallMoleculeSummary.  # noqa: E501
        :type: list[float]
        """

        self._abundance_study_variable = abundance_study_variable

    @property
    def abundance_variation_study_variable(self):
        """Gets the abundance_variation_study_variable of this SmallMoleculeSummary.  # noqa: E501


        :return: The abundance_variation_study_variable of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[float]
        """
        return self._abundance_variation_study_variable

    @abundance_variation_study_variable.setter
    def abundance_variation_study_variable(self, abundance_variation_study_variable):
        """Sets the abundance_variation_study_variable of this SmallMoleculeSummary.


        :param abundance_variation_study_variable: The abundance_variation_study_variable of this SmallMoleculeSummary.  # noqa: E501
        :type: list[float]
        """

        self._abundance_variation_study_variable = abundance_variation_study_variable

    @property
    def opt(self):
        """Gets the opt of this SmallMoleculeSummary.  # noqa: E501


        :return: The opt of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[OptColumnMapping]
        """
        return self._opt

    @opt.setter
    def opt(self, opt):
        """Sets the opt of this SmallMoleculeSummary.


        :param opt: The opt of this SmallMoleculeSummary.  # noqa: E501
        :type: list[OptColumnMapping]
        """

        self._opt = opt

    @property
    def comment(self):
        """Gets the comment of this SmallMoleculeSummary.  # noqa: E501


        :return: The comment of this SmallMoleculeSummary.  # noqa: E501
        :rtype: list[Comment]
        """
        return self._comment

    @comment.setter
    def comment(self, comment):
        """Sets the comment of this SmallMoleculeSummary.


        :param comment: The comment of this SmallMoleculeSummary.  # noqa: E501
        :type: list[Comment]
        """

        self._comment = comment

    def to_dict(self):
        """Returns the model properties as a dict"""
        result = {}

        for attr, _ in six.iteritems(self.swagger_types):
            value = getattr(self, attr)
            if isinstance(value, list):
                result[attr] = list(map(
                    lambda x: x.to_dict() if hasattr(x, "to_dict") else x,
                    value
                ))
            elif hasattr(value, "to_dict"):
                result[attr] = value.to_dict()
            elif isinstance(value, dict):
                result[attr] = dict(map(
                    lambda item: (item[0], item[1].to_dict())
                    if hasattr(item[1], "to_dict") else item,
                    value.items()
                ))
            else:
                result[attr] = value

        return result

    def to_str(self):
        """Returns the string representation of the model"""
        return pprint.pformat(self.to_dict())

    def __repr__(self):
        """For `print` and `pprint`"""
        return self.to_str()

    def __eq__(self, other):
        """Returns true if both objects are equal"""
        if not isinstance(other, SmallMoleculeSummary):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
