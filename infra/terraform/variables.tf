# Copyright (c) HashiCorp, Inc.
# SPDX-License-Identifier: MPL-2.0

variable "region" {
  type        = string
  default     = "eu-west-1"
}

variable "access_key" {
   type        = string
}

variable "access_key_secret" {
   type        = string
}
