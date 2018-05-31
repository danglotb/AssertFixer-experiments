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

from swagger_client.models.assay import Assay  # noqa: F401,E501
from swagger_client.models.indexed_element import IndexedElement  # noqa: F401,E501
from swagger_client.models.parameter import Parameter  # noqa: F401,E501
from swagger_client.models.sample import Sample  # noqa: F401,E501


class StudyVariable(object):
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
        'name': 'str',
        'assay_refs': 'list[Assay]',
        'sample_refs': 'list[Sample]',
        'average_function': 'Parameter',
        'variation_function': 'Parameter',
        'description': 'str',
        'factors': 'list[Parameter]'
    }

    attribute_map = {
        'name': 'name',
        'assay_refs': 'assay_refs',
        'sample_refs': 'sample_refs',
        'average_function': 'average_function',
        'variation_function': 'variation_function',
        'description': 'description',
        'factors': 'factors'
    }

    def __init__(self, name=None, assay_refs=None, sample_refs=None, average_function=None, variation_function=None, description=None, factors=None):  # noqa: E501
        """StudyVariable - a model defined in Swagger"""  # noqa: E501

        self._name = None
        self._assay_refs = None
        self._sample_refs = None
        self._average_function = None
        self._variation_function = None
        self._description = None
        self._factors = None
        self.discriminator = None

        self.name = name
        if assay_refs is not None:
            self.assay_refs = assay_refs
        if sample_refs is not None:
            self.sample_refs = sample_refs
        if average_function is not None:
            self.average_function = average_function
        if variation_function is not None:
            self.variation_function = variation_function
        if description is not None:
            self.description = description
        if factors is not None:
            self.factors = factors

    @property
    def name(self):
        """Gets the name of this StudyVariable.  # noqa: E501


        :return: The name of this StudyVariable.  # noqa: E501
        :rtype: str
        """
        return self._name

    @name.setter
    def name(self, name):
        """Sets the name of this StudyVariable.


        :param name: The name of this StudyVariable.  # noqa: E501
        :type: str
        """
        if name is None:
            raise ValueError("Invalid value for `name`, must not be `None`")  # noqa: E501

        self._name = name

    @property
    def assay_refs(self):
        """Gets the assay_refs of this StudyVariable.  # noqa: E501


        :return: The assay_refs of this StudyVariable.  # noqa: E501
        :rtype: list[Assay]
        """
        return self._assay_refs

    @assay_refs.setter
    def assay_refs(self, assay_refs):
        """Sets the assay_refs of this StudyVariable.


        :param assay_refs: The assay_refs of this StudyVariable.  # noqa: E501
        :type: list[Assay]
        """

        self._assay_refs = assay_refs

    @property
    def sample_refs(self):
        """Gets the sample_refs of this StudyVariable.  # noqa: E501


        :return: The sample_refs of this StudyVariable.  # noqa: E501
        :rtype: list[Sample]
        """
        return self._sample_refs

    @sample_refs.setter
    def sample_refs(self, sample_refs):
        """Sets the sample_refs of this StudyVariable.


        :param sample_refs: The sample_refs of this StudyVariable.  # noqa: E501
        :type: list[Sample]
        """

        self._sample_refs = sample_refs

    @property
    def average_function(self):
        """Gets the average_function of this StudyVariable.  # noqa: E501


        :return: The average_function of this StudyVariable.  # noqa: E501
        :rtype: Parameter
        """
        return self._average_function

    @average_function.setter
    def average_function(self, average_function):
        """Sets the average_function of this StudyVariable.


        :param average_function: The average_function of this StudyVariable.  # noqa: E501
        :type: Parameter
        """

        self._average_function = average_function

    @property
    def variation_function(self):
        """Gets the variation_function of this StudyVariable.  # noqa: E501


        :return: The variation_function of this StudyVariable.  # noqa: E501
        :rtype: Parameter
        """
        return self._variation_function

    @variation_function.setter
    def variation_function(self, variation_function):
        """Sets the variation_function of this StudyVariable.


        :param variation_function: The variation_function of this StudyVariable.  # noqa: E501
        :type: Parameter
        """

        self._variation_function = variation_function

    @property
    def description(self):
        """Gets the description of this StudyVariable.  # noqa: E501


        :return: The description of this StudyVariable.  # noqa: E501
        :rtype: str
        """
        return self._description

    @description.setter
    def description(self, description):
        """Sets the description of this StudyVariable.


        :param description: The description of this StudyVariable.  # noqa: E501
        :type: str
        """

        self._description = description

    @property
    def factors(self):
        """Gets the factors of this StudyVariable.  # noqa: E501


        :return: The factors of this StudyVariable.  # noqa: E501
        :rtype: list[Parameter]
        """
        return self._factors

    @factors.setter
    def factors(self, factors):
        """Sets the factors of this StudyVariable.


        :param factors: The factors of this StudyVariable.  # noqa: E501
        :type: list[Parameter]
        """

        self._factors = factors

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
        if not isinstance(other, StudyVariable):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
