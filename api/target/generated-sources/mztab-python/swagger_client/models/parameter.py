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

from swagger_client.models.indexed_element import IndexedElement  # noqa: F401,E501


class Parameter(object):
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
        'cv_label': 'str',
        'cv_accession': 'str',
        'name': 'str',
        'value': 'str'
    }

    attribute_map = {
        'cv_label': 'cv_label',
        'cv_accession': 'cv_accession',
        'name': 'name',
        'value': 'value'
    }

    def __init__(self, cv_label='', cv_accession='', name=None, value=''):  # noqa: E501
        """Parameter - a model defined in Swagger"""  # noqa: E501

        self._cv_label = None
        self._cv_accession = None
        self._name = None
        self._value = None
        self.discriminator = None

        if cv_label is not None:
            self.cv_label = cv_label
        if cv_accession is not None:
            self.cv_accession = cv_accession
        self.name = name
        self.value = value

    @property
    def cv_label(self):
        """Gets the cv_label of this Parameter.  # noqa: E501


        :return: The cv_label of this Parameter.  # noqa: E501
        :rtype: str
        """
        return self._cv_label

    @cv_label.setter
    def cv_label(self, cv_label):
        """Sets the cv_label of this Parameter.


        :param cv_label: The cv_label of this Parameter.  # noqa: E501
        :type: str
        """

        self._cv_label = cv_label

    @property
    def cv_accession(self):
        """Gets the cv_accession of this Parameter.  # noqa: E501


        :return: The cv_accession of this Parameter.  # noqa: E501
        :rtype: str
        """
        return self._cv_accession

    @cv_accession.setter
    def cv_accession(self, cv_accession):
        """Sets the cv_accession of this Parameter.


        :param cv_accession: The cv_accession of this Parameter.  # noqa: E501
        :type: str
        """

        self._cv_accession = cv_accession

    @property
    def name(self):
        """Gets the name of this Parameter.  # noqa: E501


        :return: The name of this Parameter.  # noqa: E501
        :rtype: str
        """
        return self._name

    @name.setter
    def name(self, name):
        """Sets the name of this Parameter.


        :param name: The name of this Parameter.  # noqa: E501
        :type: str
        """
        if name is None:
            raise ValueError("Invalid value for `name`, must not be `None`")  # noqa: E501

        self._name = name

    @property
    def value(self):
        """Gets the value of this Parameter.  # noqa: E501


        :return: The value of this Parameter.  # noqa: E501
        :rtype: str
        """
        return self._value

    @value.setter
    def value(self, value):
        """Sets the value of this Parameter.


        :param value: The value of this Parameter.  # noqa: E501
        :type: str
        """
        if value is None:
            raise ValueError("Invalid value for `value`, must not be `None`")  # noqa: E501

        self._value = value

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
        if not isinstance(other, Parameter):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
