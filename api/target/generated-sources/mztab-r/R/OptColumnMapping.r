# mzTab validation API.
# 
# This is an mzTab validation service.
# 
# OpenAPI spec version: 1.1.0
# Contact: nils.hoffmann@isas.de
# Generated by: https://github.com/swagger-api/swagger-codegen.git


#' OptColumnMapping Class
#'
#' @field identifier 
#' @field param 
#' @field value 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
OptColumnMapping <- R6::R6Class(
  'OptColumnMapping',
  public = list(
    `identifier` = NULL,
    `param` = NULL,
    `value` = NULL,
    initialize = function(`identifier`, `param`, `value`){
      if (!missing(`identifier`)) {
        stopifnot(is.character(`identifier`), length(`identifier`) == 1)
        self$`identifier` <- `identifier`
      }
      if (!missing(`param`)) {
        stopifnot(R6::is.R6(`param`))
        self$`param` <- `param`
      }
      if (!missing(`value`)) {
        stopifnot(is.character(`value`), length(`value`) == 1)
        self$`value` <- `value`
      }
    },
    toJSON = function() {
      OptColumnMappingObject <- list()
      if (!is.null(self$`identifier`)) {
        OptColumnMappingObject[['identifier']] <- self$`identifier`
      }
      if (!is.null(self$`param`)) {
        OptColumnMappingObject[['param']] <- self$`param`$toJSON()
      }
      if (!is.null(self$`value`)) {
        OptColumnMappingObject[['value']] <- self$`value`
      }

      OptColumnMappingObject
    },
    fromJSON = function(OptColumnMappingJson) {
      OptColumnMappingObject <- jsonlite::fromJSON(OptColumnMappingJson, simplifyVector = FALSE)
      if (!is.null(OptColumnMappingObject$`identifier`)) {
        self$`identifier` <- OptColumnMappingObject$`identifier`
      }
      if (!is.null(OptColumnMappingObject$`param`)) {
        `paramObject` <- Parameter$new()
        `paramObject`$fromJSON(jsonlite::toJSON(OptColumnMappingObject$param, auto_unbox = TRUE))
        self$`param` <- `paramObject`
      }
      if (!is.null(OptColumnMappingObject$`value`)) {
        self$`value` <- OptColumnMappingObject$`value`
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "identifier": %s,
           "param": %s,
           "value": %s
        }',
        self$`identifier`,
        self$`param`$toJSON(),
        self$`value`
      )
    },
    fromJSONString = function(OptColumnMappingJson) {
      OptColumnMappingObject <- jsonlite::fromJSON(OptColumnMappingJson, simplifyVector = FALSE)
      self$`identifier` <- OptColumnMappingObject$`identifier`
      ParameterObject <- Parameter$new()
      self$`param` <- ParameterObject$fromJSON(jsonlite::toJSON(OptColumnMappingObject$param, auto_unbox = TRUE))
      self$`value` <- OptColumnMappingObject$`value`
    }
  )
)
