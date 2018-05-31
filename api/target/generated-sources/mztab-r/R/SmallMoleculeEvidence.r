# mzTab validation API.
# 
# This is an mzTab validation service.
# 
# OpenAPI spec version: 1.1.0
# Contact: nils.hoffmann@isas.de
# Generated by: https://github.com/swagger-api/swagger-codegen.git


#' SmallMoleculeEvidence Class
#'
#' @field prefix 
#' @field header_prefix 
#' @field sme_id 
#' @field evidence_input_id 
#' @field database_identifier 
#' @field chemical_formula 
#' @field smiles 
#' @field inchi 
#' @field chemical_name 
#' @field uri 
#' @field derivatized_form 
#' @field adduct_ion 
#' @field exp_mass_to_charge 
#' @field charge 
#' @field theoretical_mass_to_charge 
#' @field spectra_ref 
#' @field identification_method 
#' @field ms_level 
#' @field id_confidence_measure 
#' @field rank 
#' @field opt 
#' @field comment 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
SmallMoleculeEvidence <- R6::R6Class(
  'SmallMoleculeEvidence',
  public = list(
    `prefix` = NULL,
    `header_prefix` = NULL,
    `sme_id` = NULL,
    `evidence_input_id` = NULL,
    `database_identifier` = NULL,
    `chemical_formula` = NULL,
    `smiles` = NULL,
    `inchi` = NULL,
    `chemical_name` = NULL,
    `uri` = NULL,
    `derivatized_form` = NULL,
    `adduct_ion` = NULL,
    `exp_mass_to_charge` = NULL,
    `charge` = NULL,
    `theoretical_mass_to_charge` = NULL,
    `spectra_ref` = NULL,
    `identification_method` = NULL,
    `ms_level` = NULL,
    `id_confidence_measure` = NULL,
    `rank` = NULL,
    `opt` = NULL,
    `comment` = NULL,
    initialize = function(`prefix`, `header_prefix`, `sme_id`, `evidence_input_id`, `database_identifier`, `chemical_formula`, `smiles`, `inchi`, `chemical_name`, `uri`, `derivatized_form`, `adduct_ion`, `exp_mass_to_charge`, `charge`, `theoretical_mass_to_charge`, `spectra_ref`, `identification_method`, `ms_level`, `id_confidence_measure`, `rank`, `opt`, `comment`){
      if (!missing(`prefix`)) {
        stopifnot(is.character(`prefix`), length(`prefix`) == 1)
        self$`prefix` <- `prefix`
      }
      if (!missing(`header_prefix`)) {
        stopifnot(is.character(`header_prefix`), length(`header_prefix`) == 1)
        self$`header_prefix` <- `header_prefix`
      }
      if (!missing(`sme_id`)) {
        stopifnot(is.character(`sme_id`), length(`sme_id`) == 1)
        self$`sme_id` <- `sme_id`
      }
      if (!missing(`evidence_input_id`)) {
        stopifnot(is.character(`evidence_input_id`), length(`evidence_input_id`) == 1)
        self$`evidence_input_id` <- `evidence_input_id`
      }
      if (!missing(`database_identifier`)) {
        stopifnot(is.character(`database_identifier`), length(`database_identifier`) == 1)
        self$`database_identifier` <- `database_identifier`
      }
      if (!missing(`chemical_formula`)) {
        stopifnot(is.character(`chemical_formula`), length(`chemical_formula`) == 1)
        self$`chemical_formula` <- `chemical_formula`
      }
      if (!missing(`smiles`)) {
        stopifnot(is.character(`smiles`), length(`smiles`) == 1)
        self$`smiles` <- `smiles`
      }
      if (!missing(`inchi`)) {
        stopifnot(is.character(`inchi`), length(`inchi`) == 1)
        self$`inchi` <- `inchi`
      }
      if (!missing(`chemical_name`)) {
        stopifnot(is.character(`chemical_name`), length(`chemical_name`) == 1)
        self$`chemical_name` <- `chemical_name`
      }
      if (!missing(`uri`)) {
        stopifnot(is.character(`uri`), length(`uri`) == 1)
        self$`uri` <- `uri`
      }
      if (!missing(`derivatized_form`)) {
        stopifnot(R6::is.R6(`derivatized_form`))
        self$`derivatized_form` <- `derivatized_form`
      }
      if (!missing(`adduct_ion`)) {
        stopifnot(is.character(`adduct_ion`), length(`adduct_ion`) == 1)
        self$`adduct_ion` <- `adduct_ion`
      }
      if (!missing(`exp_mass_to_charge`)) {
        stopifnot(is.numeric(`exp_mass_to_charge`), length(`exp_mass_to_charge`) == 1)
        self$`exp_mass_to_charge` <- `exp_mass_to_charge`
      }
      if (!missing(`charge`)) {
        stopifnot(is.numeric(`charge`), length(`charge`) == 1)
        self$`charge` <- `charge`
      }
      if (!missing(`theoretical_mass_to_charge`)) {
        stopifnot(is.numeric(`theoretical_mass_to_charge`), length(`theoretical_mass_to_charge`) == 1)
        self$`theoretical_mass_to_charge` <- `theoretical_mass_to_charge`
      }
      if (!missing(`spectra_ref`)) {
        stopifnot(is.list(`spectra_ref`), length(`spectra_ref`) != 0)
        lapply(`spectra_ref`, function(x) stopifnot(R6::is.R6(x)))
        self$`spectra_ref` <- `spectra_ref`
      }
      if (!missing(`identification_method`)) {
        stopifnot(R6::is.R6(`identification_method`))
        self$`identification_method` <- `identification_method`
      }
      if (!missing(`ms_level`)) {
        stopifnot(R6::is.R6(`ms_level`))
        self$`ms_level` <- `ms_level`
      }
      if (!missing(`id_confidence_measure`)) {
        stopifnot(is.list(`id_confidence_measure`), length(`id_confidence_measure`) != 0)
        lapply(`id_confidence_measure`, function(x) stopifnot(is.character(x)))
        self$`id_confidence_measure` <- `id_confidence_measure`
      }
      if (!missing(`rank`)) {
        stopifnot(is.numeric(`rank`), length(`rank`) == 1)
        self$`rank` <- `rank`
      }
      if (!missing(`opt`)) {
        stopifnot(is.list(`opt`), length(`opt`) != 0)
        lapply(`opt`, function(x) stopifnot(R6::is.R6(x)))
        self$`opt` <- `opt`
      }
      if (!missing(`comment`)) {
        stopifnot(is.list(`comment`), length(`comment`) != 0)
        lapply(`comment`, function(x) stopifnot(R6::is.R6(x)))
        self$`comment` <- `comment`
      }
    },
    toJSON = function() {
      SmallMoleculeEvidenceObject <- list()
      if (!is.null(self$`prefix`)) {
        SmallMoleculeEvidenceObject[['prefix']] <- self$`prefix`
      }
      if (!is.null(self$`header_prefix`)) {
        SmallMoleculeEvidenceObject[['header_prefix']] <- self$`header_prefix`
      }
      if (!is.null(self$`sme_id`)) {
        SmallMoleculeEvidenceObject[['sme_id']] <- self$`sme_id`
      }
      if (!is.null(self$`evidence_input_id`)) {
        SmallMoleculeEvidenceObject[['evidence_input_id']] <- self$`evidence_input_id`
      }
      if (!is.null(self$`database_identifier`)) {
        SmallMoleculeEvidenceObject[['database_identifier']] <- self$`database_identifier`
      }
      if (!is.null(self$`chemical_formula`)) {
        SmallMoleculeEvidenceObject[['chemical_formula']] <- self$`chemical_formula`
      }
      if (!is.null(self$`smiles`)) {
        SmallMoleculeEvidenceObject[['smiles']] <- self$`smiles`
      }
      if (!is.null(self$`inchi`)) {
        SmallMoleculeEvidenceObject[['inchi']] <- self$`inchi`
      }
      if (!is.null(self$`chemical_name`)) {
        SmallMoleculeEvidenceObject[['chemical_name']] <- self$`chemical_name`
      }
      if (!is.null(self$`uri`)) {
        SmallMoleculeEvidenceObject[['uri']] <- self$`uri`
      }
      if (!is.null(self$`derivatized_form`)) {
        SmallMoleculeEvidenceObject[['derivatized_form']] <- self$`derivatized_form`$toJSON()
      }
      if (!is.null(self$`adduct_ion`)) {
        SmallMoleculeEvidenceObject[['adduct_ion']] <- self$`adduct_ion`
      }
      if (!is.null(self$`exp_mass_to_charge`)) {
        SmallMoleculeEvidenceObject[['exp_mass_to_charge']] <- self$`exp_mass_to_charge`
      }
      if (!is.null(self$`charge`)) {
        SmallMoleculeEvidenceObject[['charge']] <- self$`charge`
      }
      if (!is.null(self$`theoretical_mass_to_charge`)) {
        SmallMoleculeEvidenceObject[['theoretical_mass_to_charge']] <- self$`theoretical_mass_to_charge`
      }
      if (!is.null(self$`spectra_ref`)) {
        SmallMoleculeEvidenceObject[['spectra_ref']] <- lapply(self$`spectra_ref`, function(x) x$toJSON())
      }
      if (!is.null(self$`identification_method`)) {
        SmallMoleculeEvidenceObject[['identification_method']] <- self$`identification_method`$toJSON()
      }
      if (!is.null(self$`ms_level`)) {
        SmallMoleculeEvidenceObject[['ms_level']] <- self$`ms_level`$toJSON()
      }
      if (!is.null(self$`id_confidence_measure`)) {
        SmallMoleculeEvidenceObject[['id_confidence_measure']] <- self$`id_confidence_measure`
      }
      if (!is.null(self$`rank`)) {
        SmallMoleculeEvidenceObject[['rank']] <- self$`rank`
      }
      if (!is.null(self$`opt`)) {
        SmallMoleculeEvidenceObject[['opt']] <- lapply(self$`opt`, function(x) x$toJSON())
      }
      if (!is.null(self$`comment`)) {
        SmallMoleculeEvidenceObject[['comment']] <- lapply(self$`comment`, function(x) x$toJSON())
      }

      SmallMoleculeEvidenceObject
    },
    fromJSON = function(SmallMoleculeEvidenceJson) {
      SmallMoleculeEvidenceObject <- jsonlite::fromJSON(SmallMoleculeEvidenceJson, simplifyVector = FALSE)
      if (!is.null(SmallMoleculeEvidenceObject$`prefix`)) {
        self$`prefix` <- SmallMoleculeEvidenceObject$`prefix`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`header_prefix`)) {
        self$`header_prefix` <- SmallMoleculeEvidenceObject$`header_prefix`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`sme_id`)) {
        self$`sme_id` <- SmallMoleculeEvidenceObject$`sme_id`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`evidence_input_id`)) {
        self$`evidence_input_id` <- SmallMoleculeEvidenceObject$`evidence_input_id`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`database_identifier`)) {
        self$`database_identifier` <- SmallMoleculeEvidenceObject$`database_identifier`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`chemical_formula`)) {
        self$`chemical_formula` <- SmallMoleculeEvidenceObject$`chemical_formula`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`smiles`)) {
        self$`smiles` <- SmallMoleculeEvidenceObject$`smiles`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`inchi`)) {
        self$`inchi` <- SmallMoleculeEvidenceObject$`inchi`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`chemical_name`)) {
        self$`chemical_name` <- SmallMoleculeEvidenceObject$`chemical_name`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`uri`)) {
        self$`uri` <- SmallMoleculeEvidenceObject$`uri`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`derivatized_form`)) {
        `derivatized_formObject` <- Parameter$new()
        `derivatized_formObject`$fromJSON(jsonlite::toJSON(SmallMoleculeEvidenceObject$derivatized_form, auto_unbox = TRUE))
        self$`derivatized_form` <- `derivatized_formObject`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`adduct_ion`)) {
        self$`adduct_ion` <- SmallMoleculeEvidenceObject$`adduct_ion`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`exp_mass_to_charge`)) {
        self$`exp_mass_to_charge` <- SmallMoleculeEvidenceObject$`exp_mass_to_charge`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`charge`)) {
        self$`charge` <- SmallMoleculeEvidenceObject$`charge`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`theoretical_mass_to_charge`)) {
        self$`theoretical_mass_to_charge` <- SmallMoleculeEvidenceObject$`theoretical_mass_to_charge`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`spectra_ref`)) {
        self$`spectra_ref` <- lapply(SmallMoleculeEvidenceObject$`spectra_ref`, function(x) {
          `spectra_refObject` <- SpectraRef$new()
          `spectra_refObject`$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          `spectra_refObject`
        })
      }
      if (!is.null(SmallMoleculeEvidenceObject$`identification_method`)) {
        `identification_methodObject` <- Parameter$new()
        `identification_methodObject`$fromJSON(jsonlite::toJSON(SmallMoleculeEvidenceObject$identification_method, auto_unbox = TRUE))
        self$`identification_method` <- `identification_methodObject`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`ms_level`)) {
        `ms_levelObject` <- Parameter$new()
        `ms_levelObject`$fromJSON(jsonlite::toJSON(SmallMoleculeEvidenceObject$ms_level, auto_unbox = TRUE))
        self$`ms_level` <- `ms_levelObject`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`id_confidence_measure`)) {
        self$`id_confidence_measure` <- SmallMoleculeEvidenceObject$`id_confidence_measure`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`rank`)) {
        self$`rank` <- SmallMoleculeEvidenceObject$`rank`
      }
      if (!is.null(SmallMoleculeEvidenceObject$`opt`)) {
        self$`opt` <- lapply(SmallMoleculeEvidenceObject$`opt`, function(x) {
          `optObject` <- OptColumnMapping$new()
          `optObject`$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          `optObject`
        })
      }
      if (!is.null(SmallMoleculeEvidenceObject$`comment`)) {
        self$`comment` <- lapply(SmallMoleculeEvidenceObject$`comment`, function(x) {
          `commentObject` <- Comment$new()
          `commentObject`$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          `commentObject`
        })
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "prefix": %s,
           "header_prefix": %s,
           "sme_id": %s,
           "evidence_input_id": %s,
           "database_identifier": %s,
           "chemical_formula": %s,
           "smiles": %s,
           "inchi": %s,
           "chemical_name": %s,
           "uri": %s,
           "derivatized_form": %s,
           "adduct_ion": %s,
           "exp_mass_to_charge": %d,
           "charge": %s,
           "theoretical_mass_to_charge": %d,
           "spectra_ref": [%s],
           "identification_method": %s,
           "ms_level": %s,
           "id_confidence_measure": [%s],
           "rank": %s,
           "opt": [%s],
           "comment": [%s]
        }',
        self$`prefix`,
        self$`header_prefix`,
        self$`sme_id`,
        self$`evidence_input_id`,
        self$`database_identifier`,
        self$`chemical_formula`,
        self$`smiles`,
        self$`inchi`,
        self$`chemical_name`,
        self$`uri`,
        self$`derivatized_form`$toJSON(),
        self$`adduct_ion`,
        self$`exp_mass_to_charge`,
        self$`charge`,
        self$`theoretical_mass_to_charge`,
        lapply(self$`spectra_ref`, function(x) paste(x$toJSON(), sep=",")),
        self$`identification_method`$toJSON(),
        self$`ms_level`$toJSON(),
        lapply(self$`id_confidence_measure`, function(x) paste(paste0('"', x, '"'), sep=",")),
        self$`rank`,
        lapply(self$`opt`, function(x) paste(x$toJSON(), sep=",")),
        lapply(self$`comment`, function(x) paste(x$toJSON(), sep=","))
      )
    },
    fromJSONString = function(SmallMoleculeEvidenceJson) {
      SmallMoleculeEvidenceObject <- jsonlite::fromJSON(SmallMoleculeEvidenceJson, simplifyVector = FALSE)
      self$`prefix` <- SmallMoleculeEvidenceObject$`prefix`
      self$`header_prefix` <- SmallMoleculeEvidenceObject$`header_prefix`
      self$`sme_id` <- SmallMoleculeEvidenceObject$`sme_id`
      self$`evidence_input_id` <- SmallMoleculeEvidenceObject$`evidence_input_id`
      self$`database_identifier` <- SmallMoleculeEvidenceObject$`database_identifier`
      self$`chemical_formula` <- SmallMoleculeEvidenceObject$`chemical_formula`
      self$`smiles` <- SmallMoleculeEvidenceObject$`smiles`
      self$`inchi` <- SmallMoleculeEvidenceObject$`inchi`
      self$`chemical_name` <- SmallMoleculeEvidenceObject$`chemical_name`
      self$`uri` <- SmallMoleculeEvidenceObject$`uri`
      ParameterObject <- Parameter$new()
      self$`derivatized_form` <- ParameterObject$fromJSON(jsonlite::toJSON(SmallMoleculeEvidenceObject$derivatized_form, auto_unbox = TRUE))
      self$`adduct_ion` <- SmallMoleculeEvidenceObject$`adduct_ion`
      self$`exp_mass_to_charge` <- SmallMoleculeEvidenceObject$`exp_mass_to_charge`
      self$`charge` <- SmallMoleculeEvidenceObject$`charge`
      self$`theoretical_mass_to_charge` <- SmallMoleculeEvidenceObject$`theoretical_mass_to_charge`
      self$`spectra_ref` <- lapply(SmallMoleculeEvidenceObject$`spectra_ref`, function(x) SpectraRef$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
      ParameterObject <- Parameter$new()
      self$`identification_method` <- ParameterObject$fromJSON(jsonlite::toJSON(SmallMoleculeEvidenceObject$identification_method, auto_unbox = TRUE))
      ParameterObject <- Parameter$new()
      self$`ms_level` <- ParameterObject$fromJSON(jsonlite::toJSON(SmallMoleculeEvidenceObject$ms_level, auto_unbox = TRUE))
      self$`id_confidence_measure` <- SmallMoleculeEvidenceObject$`id_confidence_measure`
      self$`rank` <- SmallMoleculeEvidenceObject$`rank`
      self$`opt` <- lapply(SmallMoleculeEvidenceObject$`opt`, function(x) OptColumnMapping$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
      self$`comment` <- lapply(SmallMoleculeEvidenceObject$`comment`, function(x) Comment$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
    }
  )
)
