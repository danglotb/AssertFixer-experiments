# mzTab validation API.
# 
# This is an mzTab validation service.
# 
# OpenAPI spec version: 1.1.0
# Contact: nils.hoffmann@isas.de
# Generated by: https://github.com/swagger-api/swagger-codegen.git


#' SampleProcessing Class
#'
#' @field id 
#' @field elementType 
#' @field sampleProcessing 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
SampleProcessing <- R6::R6Class(
  'SampleProcessing',
  public = list(
    `id` = NULL,
    `elementType` = NULL,
    `sampleProcessing` = NULL,
    initialize = function(`id`, `elementType`, `sampleProcessing`){
      if (!missing(`id`)) {
        stopifnot(is.numeric(`id`), length(`id`) == 1)
        self$`id` <- `id`
      }
      if (!missing(`elementType`)) {
        stopifnot(is.character(`elementType`), length(`elementType`) == 1)
        self$`elementType` <- `elementType`
      }
      if (!missing(`sampleProcessing`)) {
        stopifnot(is.list(`sampleProcessing`), length(`sampleProcessing`) != 0)
        lapply(`sampleProcessing`, function(x) stopifnot(R6::is.R6(x)))
        self$`sampleProcessing` <- `sampleProcessing`
      }
    },
    toJSON = function() {
      SampleProcessingObject <- list()
      if (!is.null(self$`id`)) {
        SampleProcessingObject[['id']] <- self$`id`
      }
      if (!is.null(self$`elementType`)) {
        SampleProcessingObject[['elementType']] <- self$`elementType`
      }
      if (!is.null(self$`sampleProcessing`)) {
        SampleProcessingObject[['sampleProcessing']] <- lapply(self$`sampleProcessing`, function(x) x$toJSON())
      }

      SampleProcessingObject
    },
    fromJSON = function(SampleProcessingJson) {
      SampleProcessingObject <- jsonlite::fromJSON(SampleProcessingJson, simplifyVector = FALSE)
      if (!is.null(SampleProcessingObject$`id`)) {
        self$`id` <- SampleProcessingObject$`id`
      }
      if (!is.null(SampleProcessingObject$`elementType`)) {
        self$`elementType` <- SampleProcessingObject$`elementType`
      }
      if (!is.null(SampleProcessingObject$`sampleProcessing`)) {
        self$`sampleProcessing` <- lapply(SampleProcessingObject$`sampleProcessing`, function(x) {
          `sampleProcessingObject` <- Parameter$new()
          `sampleProcessingObject`$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          `sampleProcessingObject`
        })
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "id": %s,
           "elementType": %s,
           "sampleProcessing": [%s]
        }',
        self$`id`,
        self$`elementType`,
        lapply(self$`sampleProcessing`, function(x) paste(x$toJSON(), sep=","))
      )
    },
    fromJSONString = function(SampleProcessingJson) {
      SampleProcessingObject <- jsonlite::fromJSON(SampleProcessingJson, simplifyVector = FALSE)
      self$`id` <- SampleProcessingObject$`id`
      self$`elementType` <- SampleProcessingObject$`elementType`
      self$`sampleProcessing` <- lapply(SampleProcessingObject$`sampleProcessing`, function(x) Parameter$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
    }
  )
)
