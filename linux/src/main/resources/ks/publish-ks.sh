#/bin/sh
# This script lives at https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/base-ks.cfg, but ks doesn't like https

export TMP_DIR=/tmp/push-as7-linux

rm -rf $TMP_DIR 2>/dev/null
mkdir -p $TMP_DIR
cd $TMP_DIR

wget https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/white-rabbit-lovelock-ks.cfg https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/etc/rsyslog.d/jboss-as.conf https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/lib/systemd/system/jboss-as.service


scp * people.redhat.com:/home/remote/pmcdonou/public_html/src/jboss-as7-linux/
