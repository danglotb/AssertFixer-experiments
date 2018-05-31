# mzTab validation API.
# 
# This is an mzTab validation service.
# 
# OpenAPI spec version: 1.1.0
# Contact: nils.hoffmann@isas.de
# Generated by: https://github.com/swagger-api/swagger-codegen.git


#' Comment Class
#'
#' @field prefix 
#' @field msg 
#' @field line_number 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
Comment <- R6::R6Class(
  'Comment',
  public = list(
    `prefix` = NULL,
    `msg` = NULL,
    `line_number` = NULL,
    initialize = function(`prefix`, `msg`, `line_number`){
      if (!missing(`prefix`)) {
        stopifnot(is.character(`prefix`), length(`prefix`) == 1)
        self$`prefix` <- `prefix`
      }
      if (!missing(`msg`)) {
        stopifnot(is.character(`msg`), length(`msg`) == 1)
        self$`msg` <- `msg`
      }
      if (!missing(`line_number`)) {
        stopifnot(is.numeric(`line_number`), length(`line_number`) == 1)
        self$`line_number` <- `line_number`
      }
    },
    toJSON = function() {
      CommentObject <- list()
      if (!is.null(self$`prefix`)) {
        CommentObject[['prefix']] <- self$`prefix`
      }
      if (!is.null(self$`msg`)) {
        CommentObject[['msg']] <- self$`msg`
      }
      if (!is.null(self$`line_number`)) {
        CommentObject[['line_number']] <- self$`line_number`
      }

      CommentObject
    },
    fromJSON = function(CommentJson) {
      CommentObject <- jsonlite::fromJSON(CommentJson, simplifyVector = FALSE)
      if (!is.null(CommentObject$`prefix`)) {
        self$`prefix` <- CommentObject$`prefix`
      }
      if (!is.null(CommentObject$`msg`)) {
        self$`msg` <- CommentObject$`msg`
      }
      if (!is.null(CommentObject$`line_number`)) {
        self$`line_number` <- CommentObject$`line_number`
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "prefix": %s,
           "msg": %s,
           "line_number": %s
        }',
        self$`prefix`,
        self$`msg`,
        self$`line_number`
      )
    },
    fromJSONString = function(CommentJson) {
      CommentObject <- jsonlite::fromJSON(CommentJson, simplifyVector = FALSE)
      self$`prefix` <- CommentObject$`prefix`
      self$`msg` <- CommentObject$`msg`
      self$`line_number` <- CommentObject$`line_number`
    }
  )
)
