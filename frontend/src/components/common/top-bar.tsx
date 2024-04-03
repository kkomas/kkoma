import LogoIcon from "/public/images/small-logo-icon.svg";
import NotificationsIcon from "@mui/icons-material/Notifications";
import styles from "./top-bar.module.scss";
import Link from "next/link";

export default function TopBar() {
  return (
    <>
      <div className={styles.header}>
        <Link href="/" className={styles.logo}>
          <LogoIcon width="30" height="31" />
          <span className="text-logo">KKOMA</span>
        </Link>
        <Link href="/notifications">
          <NotificationsIcon className={styles.notifications} fontSize="large" />
        </Link>
      </div>
      <div className={styles.headerSpacer}></div>
    </>
  );
}
