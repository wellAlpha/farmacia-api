provider "google" {
  credentials = file("/home/well/Documents/gpc/total-progress-398820-7c4dfa1901c7.json")
  project     = var.project
  region      = var.region
}

resource "google_sql_database_instance" "farmacia" {
  name             = "farmacia"
  database_version = "MYSQL_8_0"
  project          = var.project
  region           = var.region
  settings {
    tier = "db-f1-micro"
  }
}

resource "google_sql_user" "user" {
  name     = var.database_user
  password = var.database_user_password
  instance = google_sql_database_instance.farmacia.name
}
