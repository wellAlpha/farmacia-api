provider "google" {
  credentials = file(var.credentials_file)
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

resource "google_cloud_run_service" "app" {
  name     = var.service_name
  location = var.region
  template {
    spec {
      containers {
        image = var.image
        env {
          name  = "DB_HOST"
          value = google_sql_database_instance.farmacia.ip_address
        }
        env {
          name  = "DB_PORT"
          value = 3306
        }
        env {
          name  = "DB_NAME"
          value = "farmacia"
        }
        env {
          name  = "DB_USERNAME"
          value = var.database_user
        }
        env {
          name  = "DB_PASSWORD"
          value = var.database_user_password
        }
      }
    }
  }
}