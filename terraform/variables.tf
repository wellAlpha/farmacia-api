# variables.tf
variable "credentials_file" {
  description = "credencial"
}

variable "project" {
  description = "project id"
}

variable "region" {
  description = "região"
}

variable "database_user" {
  description = "usuário"
}

variable "database_user_password" {
  description = "senha"
}

variable "service_name" {
  description = "nome do serviço"
}

variable "image" {
  description = "nome da imagem"
}
