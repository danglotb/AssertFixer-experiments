# mzTab validation API.
# 
# This is an mzTab validation service.
# 
# OpenAPI spec version: 1.1.0
# Contact: nils.hoffmann@isas.de
# Generated by: https://github.com/swagger-api/swagger-codegen.git


#' Parameter Class
#'
#' @field id 
#' @field elementType 
#' @field cv_label 
#' @field cv_accession 
#' @field name 
#' @field value 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
Parameter <- R6::R6Class(
  'Parameter',
  public = list(
    `id` = NULL,
    `elementType` = NULL,
    `cv_label` = NULL,
    `cv_accession` = NULL,
    `name` = NULL,
    `value` = NULL,
    initialize = function(`id`, `elementType`, `cv_label`, `cv_accession`, `name`, `value`){
      if (!missing(`id`)) {
        stopifnot(is.numeric(`id`), length(`id`) == 1)
        self$`id` <- `id`
      }
      if (!missing(`elementType`)) {
        stopifnot(is.character(`elementType`), length(`elementType`) == 1)
        self$`elementType` <- `elementType`
      }
      if (!missing(`cv_label`)) {
        stopifnot(is.character(`cv_label`), length(`cv_label`) == 1)
        self$`cv_label` <- `cv_label`
      }
      if (!missing(`cv_accession`)) {
        stopifnot(is.character(`cv_accession`), length(`cv_accession`) == 1)
        self$`cv_accession` <- `cv_accession`
      }
      if (!missing(`name`)) {
        stopifnot(is.character(`name`), length(`name`) == 1)
        self$`name` <- `name`
      }
      if (!missing(`value`)) {
        stopifnot(is.character(`value`), length(`value`) == 1)
        self$`value` <- `value`
      }
    },
    toJSON = function() {
      ParameterObject <- list()
      if (!is.null(self$`id`)) {
        ParameterObject[['id']] <- self$`id`
      }
      if (!is.null(self$`elementType`)) {
        ParameterObject[['elementType']] <- self$`elementType`
      }
      if (!is.null(self$`cv_label`)) {
        ParameterObject[['cv_label']] <- self$`cv_label`
      }
      if (!is.null(self$`cv_accession`)) {
        ParameterObject[['cv_accession']] <- self$`cv_accession`
      }
      if (!is.null(self$`name`)) {
        ParameterObject[['name']] <- self$`name`
      }
      if (!is.null(self$`value`)) {
        ParameterObject[['value']] <- self$`value`
      }

      ParameterObject
    },
    fromJSON = function(ParameterJson) {
      ParameterObject <- jsonlite::fromJSON(ParameterJson, simplifyVector = FALSE)
      if (!is.null(ParameterObject$`id`)) {
        self$`id` <- ParameterObject$`id`
      }
      if (!is.null(ParameterObject$`elementType`)) {
        self$`elementType` <- ParameterObject$`elementType`
      }
      if (!is.null(ParameterObject$`cv_label`)) {
        self$`cv_label` <- ParameterObject$`cv_label`
      }
      if (!is.null(ParameterObject$`cv_accession`)) {
        self$`cv_accession` <- ParameterObject$`cv_accession`
      }
      if (!is.null(ParameterObject$`name`)) {
        self$`name` <- ParameterObject$`name`
      }
      if (!is.null(ParameterObject$`value`)) {
        self$`value` <- ParameterObject$`value`
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "id": %s,
           "elementType": %s,
           "cv_label": %s,
           "cv_accession": %s,
           "name": %s,
           "value": %s
        }',
        self$`id`,
        self$`elementType`,
        self$`cv_label`,
        self$`cv_accession`,
        self$`name`,
        self$`value`
      )
    },
    fromJSONString = function(ParameterJson) {
      ParameterObject <- jsonlite::fromJSON(ParameterJson, simplifyVector = FALSE)
      self$`id` <- ParameterObject$`id`
      self$`elementType` <- ParameterObject$`elementType`
      self$`cv_label` <- ParameterObject$`cv_label`
      self$`cv_accession` <- ParameterObject$`cv_accession`
      self$`name` <- ParameterObject$`name`
      self$`value` <- ParameterObject$`value`
    }
  )
)
