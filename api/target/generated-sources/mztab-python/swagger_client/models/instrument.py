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
from swagger_client.models.parameter import Parameter  # noqa: F401,E501


class Instrument(object):
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
        'instrument_name': 'Parameter',
        'instrument_source': 'Parameter',
        'instrument_analyzer': 'list[Parameter]',
        'instrument_detector': 'Parameter'
    }

    attribute_map = {
        'instrument_name': 'instrument_name',
        'instrument_source': 'instrument_source',
        'instrument_analyzer': 'instrument_analyzer',
        'instrument_detector': 'instrument_detector'
    }

    def __init__(self, instrument_name=None, instrument_source=None, instrument_analyzer=None, instrument_detector=None):  # noqa: E501
        """Instrument - a model defined in Swagger"""  # noqa: E501

        self._instrument_name = None
        self._instrument_source = None
        self._instrument_analyzer = None
        self._instrument_detector = None
        self.discriminator = None

        if instrument_name is not None:
            self.instrument_name = instrument_name
        if instrument_source is not None:
            self.instrument_source = instrument_source
        if instrument_analyzer is not None:
            self.instrument_analyzer = instrument_analyzer
        if instrument_detector is not None:
            self.instrument_detector = instrument_detector

    @property
    def instrument_name(self):
        """Gets the instrument_name of this Instrument.  # noqa: E501


        :return: The instrument_name of this Instrument.  # noqa: E501
        :rtype: Parameter
        """
        return self._instrument_name

    @instrument_name.setter
    def instrument_name(self, instrument_name):
        """Sets the instrument_name of this Instrument.


        :param instrument_name: The instrument_name of this Instrument.  # noqa: E501
        :type: Parameter
        """

        self._instrument_name = instrument_name

    @property
    def instrument_source(self):
        """Gets the instrument_source of this Instrument.  # noqa: E501


        :return: The instrument_source of this Instrument.  # noqa: E501
        :rtype: Parameter
        """
        return self._instrument_source

    @instrument_source.setter
    def instrument_source(self, instrument_source):
        """Sets the instrument_source of this Instrument.


        :param instrument_source: The instrument_source of this Instrument.  # noqa: E501
        :type: Parameter
        """

        self._instrument_source = instrument_source

    @property
    def instrument_analyzer(self):
        """Gets the instrument_analyzer of this Instrument.  # noqa: E501


        :return: The instrument_analyzer of this Instrument.  # noqa: E501
        :rtype: list[Parameter]
        """
        return self._instrument_analyzer

    @instrument_analyzer.setter
    def instrument_analyzer(self, instrument_analyzer):
        """Sets the instrument_analyzer of this Instrument.


        :param instrument_analyzer: The instrument_analyzer of this Instrument.  # noqa: E501
        :type: list[Parameter]
        """

        self._instrument_analyzer = instrument_analyzer

    @property
    def instrument_detector(self):
        """Gets the instrument_detector of this Instrument.  # noqa: E501


        :return: The instrument_detector of this Instrument.  # noqa: E501
        :rtype: Parameter
        """
        return self._instrument_detector

    @instrument_detector.setter
    def instrument_detector(self, instrument_detector):
        """Sets the instrument_detector of this Instrument.


        :param instrument_detector: The instrument_detector of this Instrument.  # noqa: E501
        :type: Parameter
        """

        self._instrument_detector = instrument_detector

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
        if not isinstance(other, Instrument):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
